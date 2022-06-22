package com.example.marvelcharacters.domain.usecase

import com.example.marvelcharacters.domain.model.CountryAll
import com.example.marvelcharacters.domain.repository.CountryMapLocalRepository

class GetCountryMapInsertLocalUseCase(
    private val countryMapLocalRepository: CountryMapLocalRepository
) {

    suspend operator fun invoke(country: List<CountryAll>) {
        countryMapLocalRepository.insertCountry(country)
    }

}