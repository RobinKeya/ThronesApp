package com.example.thrones.domain.data

import com.example.thrones.data.ThronesRepository
import com.example.thrones.data.di.IODispatcher
import com.example.thrones.data.remote.CharacterInfoDto
import com.example.thrones.data.remote.ThronesApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ThronesRepositoryImpl @Inject constructor (
    private val thronesApiService: ThronesApiService,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) : ThronesRepository{
    override suspend fun getCharacters(): List<CharacterInfoDto> {
        return withContext(dispatcher){
            return@withContext thronesApiService.getCharacters()
        }
    }

    override suspend fun getCharacter(id: Int): CharacterInfoDto {
        return withContext(dispatcher){
            return@withContext thronesApiService.getCharacter(id)
        }
    }

}