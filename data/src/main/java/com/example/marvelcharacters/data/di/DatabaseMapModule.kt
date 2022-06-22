package com.example.marvelcharacters.data.di

import androidx.room.Room
import com.example.marvelcharacters.data.database.AppDatabaseMap
import org.koin.dsl.module

internal val databaseMapModule = module {

    single {
        Room
            .databaseBuilder(
                get(),
                AppDatabaseMap::class.java,
                "databaseCountry"
            )
            .build()
    }

    single {
        get<AppDatabaseMap>().countryDao()
    }

}