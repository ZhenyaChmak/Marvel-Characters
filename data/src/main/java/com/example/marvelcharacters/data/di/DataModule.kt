package com.example.marvelcharacters.data.di

import org.koin.dsl.module

val dataModule = module {
    includes(
        databaseModule,
        networkMapModule,
        networkModule,
        repositoryModule,
        useCaseModule
    )
}