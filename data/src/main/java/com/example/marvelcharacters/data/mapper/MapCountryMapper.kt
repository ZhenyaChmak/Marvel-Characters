package com.example.marvelcharacters.data.mapper

import com.example.marvelcharacters.data.module.country.CountryDTO
import com.example.marvelcharacters.domain.model.Country


internal fun List<CountryDTO>.toDomainModule(): List<Country> {
    return map {
        it.toDomainModule()
    }
}

internal fun CountryDTO.toDomainModule(): Country {
    return Country(
        name = name.name
    )
}