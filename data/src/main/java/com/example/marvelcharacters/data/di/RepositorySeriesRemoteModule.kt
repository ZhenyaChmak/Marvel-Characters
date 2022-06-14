package com.example.marvelcharacters.data.di

import com.example.marvelcharacters.data.repository.CharacterSeriesRepositoryImpl
import com.example.marvelcharacters.domain.repository.CharacterSeriesRemoteRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val repositorySeriesRemoteModule = module {
    singleOf(::CharacterSeriesRepositoryImpl) {
        bind<CharacterSeriesRemoteRepository>()
    }
}