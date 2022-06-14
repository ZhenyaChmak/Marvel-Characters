package com.example.marvelcharacters.data.di

import com.example.marvelcharacters.data.repository.CharactersRemoteRepositoryImpl
import com.example.marvelcharacters.domain.repository.CharactersRemoteRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val repositoryRemoteModule = module {
    singleOf (:: CharactersRemoteRepositoryImpl){
        bind<CharactersRemoteRepository>()
    }
}