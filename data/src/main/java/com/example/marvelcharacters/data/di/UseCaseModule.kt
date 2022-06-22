package com.example.marvelcharacters.data.di

import com.example.marvelcharacters.domain.usecase.*
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val useCaseModule = module {

    singleOf(::GetCharacterComicsRemoteUseCase)

    singleOf(::GetCharacterSeriesRemoteUseCase)

    singleOf(::GetCharactersInsertLocalUseCase)

    singleOf(::GetCharactersLocalUseCase)

    singleOf(::GetCharactersQuantityLocalUseCase)

    singleOf(::GetCharactersRemoteUseCase)

    singleOf(::GetCharacterEventsRemoteUseCase)

    singleOf(::GetMapRemoteUseCase)

    singleOf(::GetMapAllRemoteUseCase)

}