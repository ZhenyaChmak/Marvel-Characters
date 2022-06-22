package com.example.marvelcharacters.data.module.series

import com.example.marvelcharacters.data.module.character.Thumbnail
import com.google.gson.annotations.SerializedName

internal data class ResultSeries(
    val id: Int,
    @SerializedName("thumbnail")
    val photoSeries: Thumbnail,
    val description: String,
    val title: String
)