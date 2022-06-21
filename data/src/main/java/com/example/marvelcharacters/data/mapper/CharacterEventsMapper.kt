package com.example.marvelcharacters.data.mapper

import com.example.marvelcharacters.data.module.events.ResultEvents
import com.example.marvelcharacters.domain.model.Events

internal fun List<ResultEvents>.toDomainModule(): List<Events> {
    return map {
        it.toDomainModel()
    }
}

internal fun ResultEvents.toDomainModel(): Events {
    return Events(
        id = id,
        photoEvents = photoEvents.path + "." + photoEvents.extension,
        description = description,
        title = title
    )
}