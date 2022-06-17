package com.example.marvelcharacters.data.di

import com.example.marvelcharacters.data.repository.CharactersLocalRepositoryImpl
import com.example.marvelcharacters.data.repository.CharactersRemoteRepositoryImpl
import com.example.marvelcharacters.domain.repository.CharacterSeriesRemoteRepository
import com.example.marvelcharacters.domain.repository.CharactersLocalRepository
import com.example.marvelcharacters.domain.repository.CharactersRemoteRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import com.example.marvelcharacters.data.repository.CharacterSeriesRepositoryImpl

internal val repositoryModule = module {

    singleOf(::CharactersRemoteRepositoryImpl) {
        bind<CharactersRemoteRepository>()
    }

    singleOf(::CharactersLocalRepositoryImpl) {
        bind<CharactersLocalRepository>()
    }

    singleOf(::CharacterSeriesRepositoryImpl) {
        bind<CharacterSeriesRemoteRepository>()
    }

}