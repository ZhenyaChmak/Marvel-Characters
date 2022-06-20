package com.example.marvelcharacters.domain.repository

import com.example.marvelcharacters.domain.model.Country

interface MapRemoteRepository {

    suspend fun getCountry(/*name: String*/): Result<List<Country>>

}