package com.example.thrones.data

import com.example.thrones.data.di.IODispatcher
import com.example.thrones.data.remote.CharacterInfoDto
import com.example.thrones.data.remote.ThronesApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

interface ThronesRepository  {
    suspend fun getCharacters():List<CharacterInfoDto>
    suspend fun getCharacter(id:Int):CharacterInfoDto
}