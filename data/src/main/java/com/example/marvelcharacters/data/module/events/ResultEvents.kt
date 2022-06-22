package com.example.marvelcharacters.data.module.events

import com.example.marvelcharacters.data.module.character.Thumbnail
import com.google.gson.annotations.SerializedName

internal data class ResultEvents(
    val id: Int,
    @SerializedName("thumbnail")
    val photoEvents: Thumbnail,
    val description: String,
    val title: String
)
