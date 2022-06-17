package com.example.marvelcharacters.domain.repository

import com.example.marvelcharacters.domain.model.Character

interface CharactersLocalRepository {

    suspend fun getCharacters(): List<Character>

    suspend fun insertCharacter(character: List<Character>)

}