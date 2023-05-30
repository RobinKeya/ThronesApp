package com.example.thrones.domain.data.models

import com.example.thrones.data.remote.CharacterInfoDto

data class CharacterInfo(
    val id: Int,
    val title: String,
    val family: String,
    val fullName: String,
    val imageUrl: String
)

fun CharacterInfoDto.toCharacterInfo(): CharacterInfo{
    return CharacterInfo(
        id = id,
        title=title,
        family=family,
        fullName = fullName,
        imageUrl = imageUrl
    )
}
