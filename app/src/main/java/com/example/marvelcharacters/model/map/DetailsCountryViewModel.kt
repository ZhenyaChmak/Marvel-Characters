package com.example.marvelcharacters.model.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelcharacters.domain.usecase.GetMapRemoteUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn

class DetailsCountryViewModel(
    private val mapRemoteUseCase: GetMapRemoteUseCase,
    private val name: String
) : ViewModel() {

    val dataFlow = flow {
        emit(mapRemoteUseCase(name))
    }.shareIn(
        scope = viewModelScope,
        replay = 1,
        started = SharingStarted.Eagerly
    )

}