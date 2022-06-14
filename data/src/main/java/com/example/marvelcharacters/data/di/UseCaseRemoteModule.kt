package com.example.marvelcharacters.data.di

import com.example.marvelcharacters.domain.usecase.GetCharactersRemoteUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val useCaseRemoteModule = module {
    singleOf(::GetCharactersRemoteUseCase)
}