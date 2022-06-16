package com.example.marvelcharacters.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelcharacters.domain.model.Character
import com.example.marvelcharacters.domain.model.LoadState
import com.example.marvelcharacters.domain.usecase.GetCharactersRemoteUseCase
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CharacterListViewModel(
    private val remoteUseCase: GetCharactersRemoteUseCase
) : ViewModel() {


    val dataFlow = flow {
        emit(remoteUseCase())
    }.shareIn(
        scope = viewModelScope,
        replay = 1,
        started = SharingStarted.Eagerly
    )

}