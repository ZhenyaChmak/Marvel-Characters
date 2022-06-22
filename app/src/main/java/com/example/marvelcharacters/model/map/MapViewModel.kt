package com.example.marvelcharacters.model.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelcharacters.domain.model.Country
import com.example.marvelcharacters.domain.usecase.GetCountryMapInsertLocalUseCase
import com.example.marvelcharacters.domain.usecase.GetMapAllRemoteUseCase
import com.example.marvelcharacters.domain.usecase.GetMapRemoteUseCase
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*

class MapViewModel(
    private val mapRemoteUseCase: GetMapRemoteUseCase,
    private val mapAllRemoteUseCase: GetMapAllRemoteUseCase,
    private val insertMapLocalUseCase: GetCountryMapInsertLocalUseCase,
) : ViewModel() {

    private val random = Random()

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
        mapAllRemoteUseCase()
            .map { list ->
                insertMapLocalUseCase(list)
                val copyList = list.toList()
                val rand = customRandom(to = copyList.size)
                val randomCountry = copyList[rand].name
                emit(mapRemoteUseCase(randomCountry))
            }
    }.shareIn(
        scope = viewModelScope,
        replay = 1,
        started = SharingStarted.Eagerly
    )

    private fun customRandom(from: Int = 0, to: Int): Int {
        return random.nextInt(to - from) + from
    }
}