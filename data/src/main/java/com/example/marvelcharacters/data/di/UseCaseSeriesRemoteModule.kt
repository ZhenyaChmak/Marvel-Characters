package com.example.marvelcharacters.data.di

import com.example.marvelcharacters.domain.usecase.GetCharacterSeriesRemoteUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val useCaseSeriesRemoteModule = module {
    singleOf(::GetCharacterSeriesRemoteUseCase)
}