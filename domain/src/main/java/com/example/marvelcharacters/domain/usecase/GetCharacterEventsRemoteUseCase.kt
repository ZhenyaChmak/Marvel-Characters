package com.example.marvelcharacters.domain.usecase

import com.example.marvelcharacters.domain.model.Events
import com.example.marvelcharacters.domain.repository.CharacterEventsRemoteRepository

class GetCharacterEventsRemoteUseCase(
    private val characterEventsRemoteRepository: CharacterEventsRemoteRepository
) {

    suspend operator fun invoke(id: Int, hash: String): Result<List<Events>> {
        return characterEventsRemoteRepository.getEvents(id, hash)
    }
}