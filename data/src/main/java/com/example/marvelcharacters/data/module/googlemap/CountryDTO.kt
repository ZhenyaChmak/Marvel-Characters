package com.example.marvelcharacters.data.module.googlemap

import com.google.gson.annotations.SerializedName

internal data class CountryDTO(
    val name: Name,
    @SerializedName("capitalInfo")
    val infoLatLng: InfoLatLng,
    val region: String,
    val capital: List<String>,
    val timezones: List<String>,
    val flags: Flag
)