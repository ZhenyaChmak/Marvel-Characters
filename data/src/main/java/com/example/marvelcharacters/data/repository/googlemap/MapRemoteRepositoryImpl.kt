package com.example.marvelcharacters.data.repository.googlemap

import com.example.marvelcharacters.data.api.GithubApiMap
import com.example.marvelcharacters.data.mapper.googlemap.toDomainModule
import com.example.marvelcharacters.domain.model.Country
import com.example.marvelcharacters.domain.repository.MapRemoteRepository

internal class MapRemoteRepositoryImpl(
    private val githubApiMap: GithubApiMap
) : MapRemoteRepository {

    override suspend fun getCountry(name: String): Result<List<Country>> {
        return runCatching {
            githubApiMap.getCountry(name)
        }.map {
            it.toDomainModule()
        }
    }

}