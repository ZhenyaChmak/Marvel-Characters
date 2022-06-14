package com.example.marvelcharacters.data.mapper

import com.example.marvelcharacters.domain.model.Character


internal fun List<com.example.marvelcharacters.data.module.Result>.toDomainModel(): List<Character> {
    return map {
        it.toDomainModel()
    }
}

internal fun com.example.marvelcharacters.data.module.Result.toDomainModel(): Character {
    return Character(
        id = id,
        name = name,
        photo = photo.path + "." + photo.extension
    )
}
