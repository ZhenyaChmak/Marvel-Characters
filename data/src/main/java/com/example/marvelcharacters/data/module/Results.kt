package com.example.marvelcharacters.data.module

import com.google.gson.annotations.SerializedName

internal data class Results(
    val id: Int,
    val name: String,
    @SerializedName("thumbnail")
    val photo: Thumbnail
)