package com.example.marvelcharacters.data.repository

import com.example.marvelcharacters.data.api.GithubApi
import com.example.marvelcharacters.data.mapper.toDomainModel
import com.example.marvelcharacters.domain.model.Character
import com.example.marvelcharacters.domain.repository.CharactersRemoteRepository
import kotlinx.coroutines.delay

internal class CharactersRemoteRepositoryImpl(
    private val githubApi: GithubApi
) : CharactersRemoteRepository {

    override suspend fun getCharacters(limit: Int, offset: Int): Result<List<Character>> {
        return runCatching {
            githubApi.getCharacters(limit, offset)
        }.map {
            it.data.results.toDomainModel()
        }
    }

}