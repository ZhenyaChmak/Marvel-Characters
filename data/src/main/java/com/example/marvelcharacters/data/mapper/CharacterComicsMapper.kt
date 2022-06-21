package com.example.marvelcharacters.data.mapper

import com.example.marvelcharacters.data.module.comics.ResultComics
import com.example.marvelcharacters.domain.model.Comics

internal fun List<ResultComics>.toDomainModel(): List<Comics> {
    return map {
        it.toDomainModel()
    }
}

internal fun ResultComics.toDomainModel(): Comics {
    return Comics(
        id = id,
        photoComics = photoComics.path + "." + photoComics.extension,
        description = description,
        title = title
    )
}