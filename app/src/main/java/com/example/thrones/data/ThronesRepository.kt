package com.example.thrones.data

import com.example.thrones.data.di.IODispatcher
import com.example.thrones.data.remote.CharacterInfo
import com.example.thrones.data.remote.ThronesApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ThronesRepository @Inject constructor(
    private val thronesApiService: ThronesApiService,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) {
    suspend fun getCharacters():List<CharacterInfo>{
        return withContext(dispatcher){
            return@withContext thronesApiService.getCharacters()
        }
    }
    suspend fun getCharacter(id:Int):CharacterInfo{
        return withContext(dispatcher){
            return@withContext thronesApiService.getCharacter(id)
        }
    }
}