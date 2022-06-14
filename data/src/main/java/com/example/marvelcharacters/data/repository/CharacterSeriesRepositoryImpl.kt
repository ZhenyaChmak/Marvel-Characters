package com.example.marvelcharacters.data.repository

import com.example.marvelcharacters.data.api.GithubApi
import com.example.marvelcharacters.data.mapper.toDomainModel
import com.example.marvelcharacters.domain.model.Series
import com.example.marvelcharacters.domain.repository.CharacterSeriesRemoteRepository

internal class CharacterSeriesRepositoryImpl(
    private val githubApi: GithubApi
) : CharacterSeriesRemoteRepository {
    override suspend fun getSeries(id: Int): Result<List<Series>> {
        return runCatching {
            githubApi.getSeries(id)
        }.map {
            it.data.results.toDomainModel()
        }
    }
}