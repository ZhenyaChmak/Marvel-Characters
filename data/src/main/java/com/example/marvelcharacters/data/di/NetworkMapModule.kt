package com.example.marvelcharacters.data.di

import com.example.marvelcharacters.data.BuildConfig
import com.example.marvelcharacters.data.api.GithubApiMap
import com.example.marvelcharacters.domain.model.CustomQualifier
import okhttp3.OkHttpClient
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

internal val networkMapModule = module {

    single {
        OkHttpClient.Builder()
            .build()
    }

    single(qualifier(CustomQualifier.MAP_BASE_URL)) {
        Retrofit.Builder()
            .baseUrl(BuildConfig.NETWORK_MAP_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single {
        get<Retrofit>(qualifier(CustomQualifier.MAP_BASE_URL)).create<GithubApiMap>()
    }

}