package com.example.marvelcharacters.domain.usecase

import com.example.marvelcharacters.domain.model.Character
import com.example.marvelcharacters.domain.repository.CharactersLocalRepository

class GetCharactersQuantityLocalUseCase(
    private val charactersQuantityLocalRepository: CharactersLocalRepository
) {

    suspend operator fun invoke(limit: Int, offset: Int): List<Character>{
        return charactersQuantityLocalRepository.getCharactersQuantity(limit, offset)
    }

}