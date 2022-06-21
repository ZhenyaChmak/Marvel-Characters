package com.example.marvelcharacters.data.repository

import com.example.marvelcharacters.data.api.GithubApiMarvel
import com.example.marvelcharacters.data.mapper.toDomainModel
import com.example.marvelcharacters.domain.model.Series
import com.example.marvelcharacters.domain.repository.CharacterSeriesRemoteRepository

internal class CharacterSeriesRemoteRepositoryImpl(
    private val githubApiMarvel: GithubApiMarvel
) : CharacterSeriesRemoteRepository {

    override suspend fun getSeries(id: Int, hash: String): Result<List<Series>> {
        return runCatching {
            githubApiMarvel.getSeries(id, hash)
        }.map {
            it.data.results.toDomainModel()
        }
    }

}