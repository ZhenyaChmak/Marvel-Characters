package com.example.marvelcharacters.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.marvelcharacters.data.module.database.CountryEntity

@Database(entities = [CountryEntity::class], version = 1)
internal abstract class AppDatabaseMap : RoomDatabase() {

    abstract fun countryDao(): CountryDao

}