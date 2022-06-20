package com.example.marvelcharacters.data.module.country

import com.google.gson.annotations.SerializedName

internal data class InfoLatLng(
    @SerializedName("latlng")
    val latLng: List<Double>
)
