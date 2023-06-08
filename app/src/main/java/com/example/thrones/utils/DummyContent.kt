package com.example.thrones.utils

import com.example.thrones.data.remote.CharacterInfoDto
import com.example.thrones.domain.data.models.CharacterInfo

object DummyContent {
    val characters = listOf<CharacterInfo>(
        CharacterInfo(1,"title1","family1","fullName1","imageURL"),
        CharacterInfo(2,"title2","family2","fullName2","imageURL"),
        CharacterInfo(3,"title3","family3","fullName3","imageURL"),
        CharacterInfo(4,"title4","family4","fullName4","imageURL"),
        CharacterInfo(5,"title5","family5","fullName5","imageURL"),
        CharacterInfo(6,"title6","family6","fullName6","imageURL"),
    )
    fun getDomainCharacters(): List<CharacterInfo>{
        return characters
    }
    fun getCharacterInfoDto(): List<CharacterInfoDto>{
        return characters.map { item->
            CharacterInfoDto(
                id = item.id,
                title = item.title,
                family = item.family,
                fullName = item.fullName,
                imageUrl = item.imageUrl,
                firstName = "",
                lastName = "",
                image = ""
            )
        }
    }
}