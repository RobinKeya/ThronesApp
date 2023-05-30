package com.example.thrones.presentation.characterDetails

import com.example.thrones.domain.data.models.CharacterInfo

data class CharacterDetailScreenState(
    val characterInfo: CharacterInfo? = null,
    val isLoading: Boolean,
    val error: String? = null
)
