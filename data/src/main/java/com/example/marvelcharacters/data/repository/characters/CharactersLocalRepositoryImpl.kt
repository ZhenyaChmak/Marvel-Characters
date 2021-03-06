package com.example.marvelcharacters.data.repository.characters

import com.example.marvelcharacters.data.database.CharacterDao
import com.example.marvelcharacters.data.mapper.toDomainModel
import com.example.marvelcharacters.data.mapper.toUserEntity
import com.example.marvelcharacters.domain.model.Character
import com.example.marvelcharacters.domain.repository.CharactersLocalRepository

internal class CharactersLocalRepositoryImpl(
    private val characterDao: CharacterDao
) : CharactersLocalRepository {

    override suspend fun getCharacters(): List<Character> {
        return characterDao.getCharacters()
            .map {
                it.toDomainModel()
            }
    }

    override suspend fun insertCharacter(character: List<Character>) {
        characterDao.insertCharacters(
            character.map {
                it.toUserEntity()
            })
    }

    override suspend fun getCharactersQuantity(limit: Int, offset: Int): List<Character> {
        return characterDao.getUsersQuantity(limit, offset)
            .map {
                it.toDomainModel()
            }
    }

}