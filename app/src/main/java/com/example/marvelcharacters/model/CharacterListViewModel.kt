package com.example.marvelcharacters.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelcharacters.data.BuildConfig
import com.example.marvelcharacters.domain.model.Character
import com.example.marvelcharacters.domain.model.LoadState
import com.example.marvelcharacters.domain.usecase.GetCharactersInsertLocalUseCase
import com.example.marvelcharacters.domain.usecase.GetCharactersLocalUseCase
import com.example.marvelcharacters.domain.usecase.GetCharactersQuantityLocalUseCase
import com.example.marvelcharacters.domain.usecase.GetCharactersRemoteUseCase
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CharacterListViewModel(
    private val remoteUseCase: GetCharactersRemoteUseCase,
    private val localUseCase: GetCharactersLocalUseCase,
    private val insertLocalUseCase: GetCharactersInsertLocalUseCase,
    private val quantityLocalUseCase: GetCharactersQuantityLocalUseCase
) : ViewModel() {

    private val _toCharacterDetails = MutableSharedFlow<Character>(
        extraBufferCapacity = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val toCharacterDetails = _toCharacterDetails.asSharedFlow()

    fun toCharacterDetails(character: Character) = viewModelScope
        .launch {
            _toCharacterDetails.tryEmit(character)
        }

    private var isLoading = false
    private var isEndList = false
    private var currentPage = 1


    private val loadSharedFlow = MutableSharedFlow<LoadState>(
        replay = 1,
        extraBufferCapacity = 0,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    fun onLoadMore() {
        loadSharedFlow.tryEmit(LoadState.LOAD)
    }

    fun onRefresh() {
        loadSharedFlow.tryEmit(LoadState.REFRESH)
    }

    val getData =
        loadSharedFlow
            .onEach {
                if (it == LoadState.REFRESH) {
                    currentPage = 1
                    isLoading = true
                }
                if (it == LoadState.LOAD)
                    isLoading = true
            }
            .filter { isLoading && !isEndList }
            .map {
                remoteUseCase(BuildConfig.HASH_KEY, currentPage * PAGE_SIZE, 0)
                    .fold(
                        onSuccess = { list ->
                            insertLocalUseCase(list)
                            if (currentPage == NUMBER_PAGES) {
                                isEndList = true
                            }
                            currentPage++
                            list
                        },
                        onFailure = {
                            emptyList()
                        }
                    )
            }
            .onEach {
                loadSharedFlow.tryEmit(LoadState.NOT_LOAD)
                isLoading = false
            }
            .onStart {
                if (localUseCase().isEmpty()) {
                    remoteUseCase(BuildConfig.HASH_KEY, currentPage * PAGE_SIZE, 0)
                        .fold(onSuccess = {
                            insertLocalUseCase(it)
                            emit(quantityLocalUseCase(currentPage * PAGE_SIZE, 0))
                        },
                            onFailure = {
                                emit(emptyList())
                            })
                } else {
                    emit(quantityLocalUseCase(currentPage * PAGE_SIZE, 0))
                }
            }

    companion object {
        private const val PAGE_SIZE = 20
        private const val NUMBER_PAGES = 100 / PAGE_SIZE
    }

}

