package com.example.marvelcharacters.data.module.country

import com.google.gson.annotations.SerializedName

internal data class CountryDTO(
    val name: Name,
    @SerializedName("capitalInfo")
    val infoLatLng : InfoLatLng
)