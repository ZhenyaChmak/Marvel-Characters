package com.example.marvelcharacters.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marvelcharacters.data.module.database.CountryEntity

@Dao
internal interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountry(country: List<CountryEntity>)

}