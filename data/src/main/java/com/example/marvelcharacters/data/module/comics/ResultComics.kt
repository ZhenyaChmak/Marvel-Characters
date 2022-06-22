package com.example.marvelcharacters.data.module.comics

import com.example.marvelcharacters.data.module.character.Thumbnail
import com.google.gson.annotations.SerializedName

internal data class ResultComics(
    val id: Int,
    @SerializedName("thumbnail")
    val photoComics: Thumbnail,
    val description: String,
    val title : String
)
