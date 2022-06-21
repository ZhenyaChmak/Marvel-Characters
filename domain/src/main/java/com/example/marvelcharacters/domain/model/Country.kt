package com.example.marvelcharacters.domain.model

data class Country(
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val region: String,
    val capital: String,
    val timezones: String,
    val flag: String
)