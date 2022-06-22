package com.example.marvelcharacters.data.mapper.googlemap

import com.example.marvelcharacters.data.module.googlemap.CountryDTO
import com.example.marvelcharacters.domain.model.CountryAll

internal fun List<CountryDTO>.toDomain(): List<CountryAll> {
    return map {
        it.toDomain()
    }
}

internal fun CountryDTO.toDomain(): CountryAll {
    return CountryAll(
        name = name.name
    )
}