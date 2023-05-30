package com.example.thrones.presentation.characterList

import com.example.thrones.domain.data.models.CharacterInfo

data class CharacterListScreenState(
    val chars : List<CharacterInfo>,
    val isLoading: Boolean,
    val error : String? = null
)