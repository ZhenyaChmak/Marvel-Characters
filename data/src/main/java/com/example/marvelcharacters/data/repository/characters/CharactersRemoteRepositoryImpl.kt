package com.example.marvelcharacters.data.repository.characters

import com.example.marvelcharacters.data.api.GithubApiMarvel
import com.example.marvelcharacters.data.mapper.toDomainModel
import com.example.marvelcharacters.domain.model.Character
import com.example.marvelcharacters.domain.repository.CharactersRemoteRepository

internal class CharactersRemoteRepositoryImpl(
    private val githubApiMarvel: GithubApiMarvel
) : CharactersRemoteRepository {

    override suspend fun getCharacters(
        hash: String,
        limit: Int,
        offset: Int,
    ): Result<List<Character>> {
        return runCatching {
            githubApiMarvel.getCharacters(hash, limit, offset)
        }.map {
            it.data.results.toDomainModel()
        }
    }

}