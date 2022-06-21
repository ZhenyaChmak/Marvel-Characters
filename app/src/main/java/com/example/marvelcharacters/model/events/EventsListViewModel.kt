package com.example.marvelcharacters.model.events

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelcharacters.data.BuildConfig
import com.example.marvelcharacters.domain.usecase.GetCharacterEventsRemoteUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn

class EventsListViewModel(
    private val eventsRemoteUseCase: GetCharacterEventsRemoteUseCase,
    private val id: Int
) : ViewModel() {

    val dataFlow = flow {
        emit(eventsRemoteUseCase(id, BuildConfig.HASH_KEY))
    }.shareIn(
        scope = viewModelScope,
        replay = 1,
        started = SharingStarted.Eagerly
    )

}