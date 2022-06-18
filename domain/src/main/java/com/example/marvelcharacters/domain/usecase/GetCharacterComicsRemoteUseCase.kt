package com.example.marvelcharacters.domain.usecase

import com.example.marvelcharacters.domain.model.Comics
import com.example.marvelcharacters.domain.repository.CharacterComicsRemoteRepository

class GetCharacterComicsRemoteUseCase(
    private val characterComicsRemoteUseCase: CharacterComicsRemoteRepository
) {

    suspend operator fun invoke(id: Int): Result<List<Comics>> {
        return characterComicsRemoteUseCase.gerComics(id)
    }

}