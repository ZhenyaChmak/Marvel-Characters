package com.example.marvelcharacters.data.repository

import com.example.marvelcharacters.data.api.GithubApi
import com.example.marvelcharacters.data.mapper.toDomainModel
import com.example.marvelcharacters.domain.model.Series
import com.example.marvelcharacters.domain.repository.CharacterSeriesRemoteRepository

internal class CharacterSeriesRemoteRepositoryImpl(
    private val githubApi: GithubApi
) : CharacterSeriesRemoteRepository {

    override suspend fun getSeries(id: Int): Result<List<Series>> {
        return runCatching {
            githubApi.getSeries(id)
        }.map {
            println()
            it.data.results.toDomainModel()
        }
    }

}