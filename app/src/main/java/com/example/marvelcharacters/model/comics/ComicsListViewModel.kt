package com.example.marvelcharacters.model.comics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelcharacters.domain.usecase.GetCharacterComicsRemoteUseCase
import com.example.marvelcharacters.domain.usecase.GetCharacterSeriesRemoteUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn

class ComicsListViewModel(
    private val comicsRemoteUseCase: GetCharacterComicsRemoteUseCase,
    private val id: Int
) : ViewModel() {

    val dataFlow = flow {
        emit(comicsRemoteUseCase(id))
    }.shareIn(
        scope = viewModelScope,
        replay = 1,
        started = SharingStarted.Eagerly
    )
}