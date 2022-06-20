package com.example.marvelcharacters.data.repository

import com.example.marvelcharacters.data.api.GithubApiMap
import com.example.marvelcharacters.data.mapper.toDomainModule
import com.example.marvelcharacters.domain.model.Country
import com.example.marvelcharacters.domain.repository.MapRemoteRepository

internal class MapRemoteRepositoryImpl(
    private val githubApiMap : GithubApiMap
): MapRemoteRepository {

    override suspend fun getCountry(/*name: String*/): Result<List<Country>> {
        return runCatching {
            githubApiMap.getCountry(/*name*/)
        }.map {
            it.toDomainModule()
        }
    }

}