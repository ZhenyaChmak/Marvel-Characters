package com.example.marvelcharacters

import android.app.Application
import com.example.marvelcharacters.data.di.dataModule
import com.example.marvelcharacters.di.characterViewModelModule
import com.example.marvelcharacters.di.details.detailsViewModelModule
import com.example.marvelcharacters.di.map.mapViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(
                dataModule,
                detailsViewModelModule,
                mapViewModelModule,
                characterViewModelModule,
            )
        }
    }
}