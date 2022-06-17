package com.example.marvelcharacters.data.mapper

import com.example.marvelcharacters.data.module.series.ResultSeries
import com.example.marvelcharacters.domain.model.Series

internal fun List<ResultSeries>.toDomainModel(): List<Series> {
    return map {
        it.toDomainModel()
    }
}

internal fun ResultSeries.toDomainModel(): Series {
    return Series(
        id = id,
        photoSeries = photoSeries.path + "." + photoSeries.extension,
        description = description
    )
}