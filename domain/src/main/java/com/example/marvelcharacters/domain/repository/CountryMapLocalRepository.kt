package com.example.marvelcharacters.domain.repository

import com.example.marvelcharacters.domain.model.CountryAll

interface CountryMapLocalRepository {

    suspend fun insertCountry(country: List<CountryAll>)

}