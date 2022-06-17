package com.example.marvelcharacters.domain.usecase

import com.example.marvelcharacters.domain.model.Character
import com.example.marvelcharacters.domain.repository.CharactersLocalRepository

class GetCharactersInsertLocalUseCase(
    private val charactersInsertLocalRepository: CharactersLocalRepository
) {

    suspend operator fun invoke(character: List<Character>) {
        charactersInsertLocalRepository.insertCharacter(character)
    }

}