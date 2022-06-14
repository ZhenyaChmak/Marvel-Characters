package com.example.marvelcharacters.domain.repository

import com.example.marvelcharacters.domain.model.Character

interface CharactersRemoteRepository {

    suspend fun getCharacters(): Result<List<Character>>
}