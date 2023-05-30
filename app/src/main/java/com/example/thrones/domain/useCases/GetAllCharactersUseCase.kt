package com.example.thrones.domain.useCases

import com.example.thrones.data.ThronesRepository
import com.example.thrones.data.di.IODispatcher
import com.example.thrones.domain.data.models.CharacterInfo
import com.example.thrones.domain.data.models.toCharacterInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(
   private val thronesRepository: ThronesRepository,
   @IODispatcher private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke():List<CharacterInfo>{
        return withContext(dispatcher){
            return@withContext thronesRepository.getCharacters().map { it.toCharacterInfo() }
        }

    }
}