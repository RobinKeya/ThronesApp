package com.example.thrones.utils

import com.example.thrones.data.remote.CharacterInfoDto

object DummyContent {
    val characters = listOf<CharacterInfoDto>(
        CharacterInfoDto("Family 1","robin","R_chemaimak",1,"","imageUrl","chemaimak","title"),
        CharacterInfoDto("Family 1","robin","R_chemaima",1,"","imageUrl","chemaimak","title"),
        CharacterInfoDto("Family 1","robin","R_chemaim",1,"","imageUrl","chemaimak","title"),
        CharacterInfoDto("Family 1","robin","R_chema",1,"","imageUrl","chemaimak","title"),
        CharacterInfoDto("Family 1","robin","_chemaimak",1,"","imageUrl","chemaimak","title"),
        CharacterInfoDto("Family 1","robin","Rchemaimak",1,"","imageUrl","chemaimak","title"),
    )
}