package com.example.marvelcharacters.domain.usecase

import com.example.marvelcharacters.domain.model.Country
import com.example.marvelcharacters.domain.repository.MapRemoteRepository

class GetMapRemoteUseCase(
    private val mapRemoteRepository: MapRemoteRepository
) {

    suspend operator fun invoke(name: String): Result<List<Country>> {
        return mapRemoteRepository.getCountry(name)
    }

}