package com.example.marvelcharacters.domain.usecase

import com.example.marvelcharacters.domain.model.Character
import com.example.marvelcharacters.domain.repository.CharactersRemoteRepository

class GetCharactersRemoteUseCase(
    private val charactersRemoteRepository: CharactersRemoteRepository
) {

    suspend operator fun invoke(hash: String, limit: Int, offset: Int): Result<List<Character>> {
        return charactersRemoteRepository.getCharacters(hash, limit, offset)
    }

}