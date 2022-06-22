package com.example.marvelcharacters.model.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelcharacters.domain.model.Country
import com.example.marvelcharacters.domain.usecase.GetMapAllRemoteUseCase
import com.example.marvelcharacters.domain.usecase.GetMapRemoteUseCase
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MapViewModel(
    private val mapRemoteUseCase: GetMapRemoteUseCase,
    private val mapAllRemoteUseCase: GetMapAllRemoteUseCase,
    private val name: String
) : ViewModel() {

    private val _toDetailsCountry = MutableSharedFlow<Country>(
        replay = 1,
        extraBufferCapacity = 0,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val nextDetailsCountry = _toDetailsCountry.asSharedFlow()

    fun toDetailsCountry(country: Country) = viewModelScope
        .launch {
            _toDetailsCountry.tryEmit(country)
        }




    val dataFlow = flow {

        emit(mapRemoteUseCase(name))
    }.shareIn(
        scope = viewModelScope,
        replay = 1,
        started = SharingStarted.Eagerly
    )

    val dataAllFlow = flow {

        emit(mapAllRemoteUseCase())
    }.shareIn(
        scope = viewModelScope,
        replay = 1,
        started = SharingStarted.Eagerly
    )

}