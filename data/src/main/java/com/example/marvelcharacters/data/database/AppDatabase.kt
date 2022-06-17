package com.example.marvelcharacters.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.marvelcharacters.data.module.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1)
internal abstract class AppDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao

}