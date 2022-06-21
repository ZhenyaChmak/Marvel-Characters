package com.example.marvelcharacters.domain.repository

import com.example.marvelcharacters.domain.model.Events

interface CharacterEventsRemoteRepository {

    suspend fun getEvents(id: Int, hash: String): Result<List<Events>>

}