package com.example.marvelcharacters.domain.usecase

import com.example.marvelcharacters.domain.model.Character
import com.example.marvelcharacters.domain.repository.CharactersLocalRepository

class GetCharactersLocalUseCase(
    private val charactersLocalRepository: CharactersLocalRepository
) {

    suspend operator fun invoke(): List<Character> {
        return charactersLocalRepository.getCharacters()
    }

}