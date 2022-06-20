package com.example.marvelcharacters.data.api

import com.example.marvelcharacters.data.module.CharacterDTO
import com.example.marvelcharacters.data.module.Results
import com.example.marvelcharacters.data.module.comics.ComicsDTO
import com.example.marvelcharacters.data.module.comics.ResultComics
import com.example.marvelcharacters.data.module.series.SeriesDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface GithubApiMarvel {

    @GET("v1/public/characters?ts=1&apikey=652c52b7418522539eec74f2dee65335")
    suspend fun getCharacters(
        @Query("hash") hash: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): CharacterDTO

    @GET("v1/public/characters/{id}/series?ts=1&apikey=652c52b7418522539eec74f2dee65335&hash=f4b5ec405ecf15e5f0e917386cd1bd1b")
    suspend fun getSeries(
        @Path("id") id: Int
    ): SeriesDTO

    @GET("v1/public/characters/{id}/comics?ts=1&apikey=652c52b7418522539eec74f2dee65335&hash=f4b5ec405ecf15e5f0e917386cd1bd1b")
    suspend fun getComics(
        @Path("id") id: Int
    ): ComicsDTO

}