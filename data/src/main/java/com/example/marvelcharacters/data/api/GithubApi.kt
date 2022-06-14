package com.example.marvelcharacters.data.api

import com.example.marvelcharacters.data.module.CharacterDTO
import com.example.marvelcharacters.data.module.series.SeriesDTO
import com.example.marvelcharacters.domain.model.Series
import retrofit2.http.GET
import retrofit2.http.Path

internal interface GithubApi {

    @GET("v1/public/characters?ts=1&apikey=652c52b7418522539eec74f2dee65335&hash=f4b5ec405ecf15e5f0e917386cd1bd1b")
    suspend fun getCharacters(): CharacterDTO


    @GET("v1/public/characters/{id}/series?ts=1&apikey=652c52b7418522539eec74f2dee65335&hash=f4b5ec405ecf15e5f0e917386cd1bd1b")
    suspend fun getSeries(
        @Path("id") id: Int
    ): SeriesDTO
}