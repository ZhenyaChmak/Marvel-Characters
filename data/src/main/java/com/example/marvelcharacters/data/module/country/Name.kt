package com.example.marvelcharacters.data.module.country

import com.google.gson.annotations.SerializedName

internal data class Name(
    @SerializedName("common")
    val name: String
)