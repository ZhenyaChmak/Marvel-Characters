package com.example.marvelcharacters.data.api

import com.example.marvelcharacters.data.module.country.CountryDTO
import retrofit2.http.GET
import retrofit2.http.Path

internal interface GithubApiMap {

    @GET("https://restcountries.com/v3.1/name/Germany")
    suspend fun getCountry(
       /* @Path("name") name: String*/
    ): List<CountryDTO>

}