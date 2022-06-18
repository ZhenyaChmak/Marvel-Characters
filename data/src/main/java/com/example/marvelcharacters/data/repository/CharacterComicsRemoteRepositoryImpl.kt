package com.example.marvelcharacters.data.repository

import com.example.marvelcharacters.data.api.GithubApi
import com.example.marvelcharacters.data.mapper.toDomainModel
import com.example.marvelcharacters.domain.model.Comics
import com.example.marvelcharacters.domain.repository.CharacterComicsRemoteRepository

internal class CharacterComicsRemoteRepositoryImpl(
    private val githubApi: GithubApi
) : CharacterComicsRemoteRepository {

    override suspend fun gerComics(id: Int): Result<List<Comics>> {
        return runCatching {
            githubApi.getComics(id)
        }.map {
            it.data.results.toDomainModel()
        }
    }

}