package com.example.marvelcharacters.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelcharacters.domain.usecase.GetCharacterSeriesRemoteUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn

class SeriesListViewModel(
    private val seriesRemoteUseCase : GetCharacterSeriesRemoteUseCase,
    private val id: Int
) : ViewModel() {

    val dataFlow = flow {
        emit(seriesRemoteUseCase(id))
    }.shareIn(
        scope = viewModelScope,
        replay = 1,
        started = SharingStarted.Eagerly
    )
}