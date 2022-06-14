package com.example.marvelcharacters.data.di

import org.koin.dsl.module

val dataModule = module {
    includes(
        networkModule,
        repositoryRemoteModule,
        repositorySeriesRemoteModule,
        useCaseRemoteModule,
        useCaseSeriesRemoteModule
    )
}