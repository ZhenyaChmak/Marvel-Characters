package com.example.marvelcharacters.data.di

import com.example.marvelcharacters.data.repository.CharacterComicsRemoteRepositoryImpl
import com.example.marvelcharacters.data.repository.CharacterSeriesRemoteRepositoryImpl
import com.example.marvelcharacters.data.repository.CharactersLocalRepositoryImpl
import com.example.marvelcharacters.data.repository.CharactersRemoteRepositoryImpl
import com.example.marvelcharacters.data.repository.MapRemoteRepositoryImpl
import com.example.marvelcharacters.domain.repository.*
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val repositoryModule = module {

    singleOf(::CharactersRemoteRepositoryImpl) {
        bind<CharactersRemoteRepository>()
    }

    singleOf(::CharactersLocalRepositoryImpl) {
        bind<CharactersLocalRepository>()
    }

    singleOf(::CharacterSeriesRemoteRepositoryImpl) {
        bind<CharacterSeriesRemoteRepository>()
    }

    singleOf(::CharacterComicsRemoteRepositoryImpl) {
        bind<CharacterComicsRemoteRepository>()
    }

    singleOf(::MapRemoteRepositoryImpl) {
        bind<MapRemoteRepository>()
    }

}