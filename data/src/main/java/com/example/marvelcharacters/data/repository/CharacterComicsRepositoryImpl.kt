package com.example.marvelcharacters.data.repository

import com.example.marvelcharacters.data.api.GithubApi
import com.example.marvelcharacters.domain.model.Comics
import com.example.marvelcharacters.domain.repository.CharacterComicsRepository

class CharacterComicsRepositoryImpl(
    private val githubApi: GithubApi
) : CharacterComicsRepository {
    override suspend fun gerComics(id: Int): Result<List<Comics>> {
        return runCatching {
            githubApi.getComics(id)
        }.map {

        }
    }
}