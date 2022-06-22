package com.example.marvelcharacters.data.di

import com.example.marvelcharacters.data.repository.characters.CharacterComicsRemoteRepositoryImpl
import com.example.marvelcharacters.data.repository.characters.CharacterEventsRemoteRepositoryImpl
import com.example.marvelcharacters.data.repository.characters.CharacterSeriesRemoteRepositoryImpl
import com.example.marvelcharacters.data.repository.characters.CharactersLocalRepositoryImpl
import com.example.marvelcharacters.data.repository.characters.CharactersRemoteRepositoryImpl
import com.example.marvelcharacters.data.repository.googlemap.MapRemoteRepositoryImpl
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

    singleOf(::CharacterEventsRemoteRepositoryImpl) {
        bind<CharacterEventsRemoteRepository>()
    }

    singleOf(::MapRemoteRepositoryImpl) {
        bind<MapRemoteRepository>()
    }

}