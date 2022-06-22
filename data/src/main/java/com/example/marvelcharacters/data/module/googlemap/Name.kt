package com.example.marvelcharacters.data.module.googlemap

import com.google.gson.annotations.SerializedName

internal data class Name(
    @SerializedName("common")
    val name: String
)