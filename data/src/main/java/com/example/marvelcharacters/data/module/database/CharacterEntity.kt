package com.example.marvelcharacters.data.module.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class CharacterEntity(
    @PrimaryKey(autoGenerate = true)
    val idAuto: Int = 0,
    @ColumnInfo(name = "idCharacter")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    val photo: String
)