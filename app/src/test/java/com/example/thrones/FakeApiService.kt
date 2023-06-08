package com.example.thrones

import com.example.thrones.data.remote.CharacterInfoDto
import com.example.thrones.data.remote.ThronesApiService
import com.example.thrones.utils.Constants
import com.example.thrones.utils.DummyContent

class FakeApiService: ThronesApiService {
    override suspend fun getCharacters(): List<CharacterInfoDto> {
        return DummyContent.getCharacterInfoDto()
    }

    override suspend fun getCharacter(id: Int): CharacterInfoDto {
        return DummyContent.getCharacterInfoDto().get(0)
    }
}