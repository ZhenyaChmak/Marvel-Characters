package com.example.marvelcharacters.domain.usecase

import com.example.marvelcharacters.domain.model.CountryAll
import com.example.marvelcharacters.domain.repository.MapAllRemoteRepository

class GetMapAllRemoteUseCase(
    private val mapAllRemoteRepository: MapAllRemoteRepository
) {

    suspend operator fun invoke(): Result<List<CountryAll>> {
        return mapAllRemoteRepository.getAllCountry()
    }

}