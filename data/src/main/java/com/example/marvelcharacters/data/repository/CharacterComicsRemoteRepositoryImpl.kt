package com.example.marvelcharacters.data.repository

import com.example.marvelcharacters.data.api.GithubApiMarvel
import com.example.marvelcharacters.data.mapper.toDomainModel
import com.example.marvelcharacters.domain.model.Comics
import com.example.marvelcharacters.domain.repository.CharacterComicsRemoteRepository

internal class CharacterComicsRemoteRepositoryImpl(
    private val githubApiMarvel: GithubApiMarvel
) : CharacterComicsRemoteRepository {

    override suspend fun gerComics(id: Int, hash: String): Result<List<Comics>> {
        return runCatching {
            githubApiMarvel.getComics(id, hash)
        }.map {
            it.data.results.toDomainModel()
        }
    }

}