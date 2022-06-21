package com.example.marvelcharacters.data.mapper

import com.example.marvelcharacters.data.module.Results
import com.example.marvelcharacters.domain.model.Character

internal fun List<Results>.toDomainModel(): List<Character> {
    return map {
        it.toDomainModel()
    }
}

internal fun Results.toDomainModel(): Character {
    return Character(
        id = id,
        name = name,
        photo = photo.path + "." + photo.extension
    )
}
