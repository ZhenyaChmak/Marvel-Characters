package com.example.marvelcharacters.domain.repository

import com.example.marvelcharacters.domain.model.CountryAll

interface MapAllRemoteRepository {

    suspend fun getAllCountry(): Result<List<CountryAll>>

}