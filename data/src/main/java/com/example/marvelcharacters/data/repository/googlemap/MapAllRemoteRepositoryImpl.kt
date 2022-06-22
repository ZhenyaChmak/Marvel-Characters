package com.example.marvelcharacters.data.repository.googlemap

import com.example.marvelcharacters.data.api.GithubApiMap
import com.example.marvelcharacters.data.mapper.googlemap.toDomain
import com.example.marvelcharacters.domain.model.CountryAll
import com.example.marvelcharacters.domain.repository.MapAllRemoteRepository

internal class MapAllRemoteRepositoryImpl(
    private val githubApiMap: GithubApiMap
) : MapAllRemoteRepository {

    override suspend fun getAllCountry(): Result<List<CountryAll>> {
        return runCatching {
            githubApiMap.getAllCountry()
        }.map {
            it.toDomain()
        }
    }

}
