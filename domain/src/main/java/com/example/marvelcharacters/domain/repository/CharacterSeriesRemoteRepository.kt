package com.example.marvelcharacters.domain.repository

import com.example.marvelcharacters.domain.model.Series

interface CharacterSeriesRemoteRepository {

    suspend fun getSeries(id: Int, hash: String): Result<List<Series>>

}