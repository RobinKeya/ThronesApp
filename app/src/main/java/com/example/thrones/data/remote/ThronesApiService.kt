package com.example.thrones.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface ThronesApiService {

    @GET("/api/v2/Characters")
    suspend fun getCharacters():List<CharacterInfo>

    @GET("/api/v2/Characters/{id}")
    suspend fun getCharacter(@Path("id")id: Int):CharacterInfo
}