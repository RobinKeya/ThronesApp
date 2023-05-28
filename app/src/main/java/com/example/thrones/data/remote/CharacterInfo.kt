package com.example.thrones.data.remote

data class CharacterInfo(
    val family: String,
    val firstName: String,
    val fullName: String,
    val id: Int,
    val image: String,
    val imageUrl: String,
    val lastName: String,
    val title: String
)