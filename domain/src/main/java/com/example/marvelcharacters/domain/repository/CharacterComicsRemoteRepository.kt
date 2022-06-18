package com.example.marvelcharacters.domain.repository

import com.example.marvelcharacters.domain.model.Comics

interface CharacterComicsRemoteRepository {

    suspend fun gerComics(id: Int): Result<List<Comics>>
}