package com.example.marvelcharacters.domain.repository

import com.example.marvelcharacters.domain.model.Character

interface CharactersRemoteRepository {

    suspend fun getCharacters(limit: Int, offset: Int): Result<List<Character>>

}