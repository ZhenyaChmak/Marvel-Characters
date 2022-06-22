package com.example.marvelcharacters.data.repository.characters

import com.example.marvelcharacters.data.database.CountryDao
import com.example.marvelcharacters.data.mapper.googlemap.toCountryEntity
import com.example.marvelcharacters.domain.model.CountryAll
import com.example.marvelcharacters.domain.repository.CountryMapLocalRepository

internal class CountryMapLocalRepositoryImpl(
    private val countryDao: CountryDao
) : CountryMapLocalRepository {

    override suspend fun insertCountry(country: List<CountryAll>) {
        countryDao.insertCountry(
            country.map {
                it.toCountryEntity()
            }
        )
    }

}