package com.example.marvelcharacters.data.mapper

import com.example.marvelcharacters.data.module.CharacterEntity
import com.example.marvelcharacters.domain.model.Character

internal fun CharacterEntity.toDomainModel(): Character {
    return Character(
        id = id,
        name = name,
        photo = photo
    )
}

internal fun Character.toUserEntity(): CharacterEntity {
    return CharacterEntity(
        id = id,
        name = name,
        photo = photo
    )
}
