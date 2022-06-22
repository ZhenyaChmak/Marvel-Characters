package com.example.marvelcharacters.data.mapper.googlemap

import com.example.marvelcharacters.data.module.database.CountryEntity
import com.example.marvelcharacters.domain.model.CountryAll

internal fun CountryAll.toCountryEntity(): CountryEntity {
    return CountryEntity(
        name = name
    )
}