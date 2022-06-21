package com.example.marvelcharacters.data.repository

import com.example.marvelcharacters.data.api.GithubApiMarvel
import com.example.marvelcharacters.data.mapper.toDomainModule
import com.example.marvelcharacters.domain.model.Events
import com.example.marvelcharacters.domain.repository.CharacterEventsRemoteRepository

internal class CharacterEventsRemoteRepositoryImpl(
    private val githubApiMarvel: GithubApiMarvel
) : CharacterEventsRemoteRepository {

    override suspend fun getEvents(id: Int, hash: String): Result<List<Events>> {
        return runCatching {
            githubApiMarvel.getEvents(id, hash)
        }.map {
            it.data.results.toDomainModule()
        }
    }

}