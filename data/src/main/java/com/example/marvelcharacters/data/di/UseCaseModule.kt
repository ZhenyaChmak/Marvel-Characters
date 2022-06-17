package com.example.marvelcharacters.data.di

import com.example.marvelcharacters.domain.usecase.GetCharacterSeriesRemoteUseCase
import com.example.marvelcharacters.domain.usecase.GetCharactersInsertLocalUseCase
import com.example.marvelcharacters.domain.usecase.GetCharactersLocalUseCase
import com.example.marvelcharacters.domain.usecase.GetCharactersRemoteUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val useCaseModule = module {

    singleOf(::GetCharactersInsertLocalUseCase)

    singleOf(::GetCharactersLocalUseCase)

    singleOf(::GetCharactersRemoteUseCase)

    singleOf(::GetCharacterSeriesRemoteUseCase)

}