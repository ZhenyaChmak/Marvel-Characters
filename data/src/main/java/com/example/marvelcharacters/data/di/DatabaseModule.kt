package com.example.marvelcharacters.data.di

import androidx.room.Room
import com.example.marvelcharacters.data.database.AppDatabase
import org.koin.dsl.module

internal val databaseModule = module {

    single {
        Room
            .databaseBuilder(
                get(),
                AppDatabase::class.java,
                "database"
            )
            .build()
    }

    single {
        get<AppDatabase>().characterDao()
    }

}