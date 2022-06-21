package com.example.marvelcharacters.domain.usecase

import com.example.marvelcharacters.domain.model.Series
import com.example.marvelcharacters.domain.repository.CharacterSeriesRemoteRepository

class GetCharacterSeriesRemoteUseCase(
    private val characterSeriesRemoteUseCase: CharacterSeriesRemoteRepository
) {

    suspend operator fun invoke(id: Int, hash: String): Result<List<Series>> {
        return characterSeriesRemoteUseCase.getSeries(id, hash)
    }

}