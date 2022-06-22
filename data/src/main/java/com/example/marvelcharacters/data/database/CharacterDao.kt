package com.example.marvelcharacters.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marvelcharacters.data.module.database.CharacterEntity

@Dao
internal interface CharacterDao {

    @Query("SELECT * FROM CharacterEntity")
    suspend fun getCharacters(): List<CharacterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(user: List<CharacterEntity>)

    @Query("SELECT * FROM CharacterEntity LIMIT :limit OFFSET :offset")
    suspend fun getUsersQuantity(limit: Int, offset: Int): List<CharacterEntity>

}