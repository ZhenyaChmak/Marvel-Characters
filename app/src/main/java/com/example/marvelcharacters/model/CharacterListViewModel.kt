package com.example.marvelcharacters.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelcharacters.domain.model.Character
import com.example.marvelcharacters.domain.usecase.GetCharactersInsertLocalUseCase
import com.example.marvelcharacters.domain.usecase.GetCharactersLocalUseCase
import com.example.marvelcharacters.domain.usecase.GetCharactersRemoteUseCase
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CharacterListViewModel(
    private val remoteUseCase: GetCharactersRemoteUseCase,
    private val localUseCase: GetCharactersLocalUseCase,
    private val insertLocalUseCase: GetCharactersInsertLocalUseCase
) : ViewModel() {

    private val _nextDetails = MutableSharedFlow<Character>(
        extraBufferCapacity = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val nextDetails = _nextDetails.asSharedFlow()

    fun toCharacterDetails(character: Character) = viewModelScope
        .launch {
            _nextDetails.tryEmit(character)
        }


    val dataFlow = flow {
        emit(remoteUseCase())
    }.shareIn(
        scope = viewModelScope,
        replay = 1,
        started = SharingStarted.Eagerly
    )

}