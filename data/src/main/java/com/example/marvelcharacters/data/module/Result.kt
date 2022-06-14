package com.example.marvelcharacters.data.module

import com.example.marvelcharacters.data.module.series.SeriesDTO
import com.google.gson.annotations.SerializedName

internal data class Result(
    val id: Int,
    val name: String,
    @SerializedName("thumbnail")
    val photo: Thumbnail
)