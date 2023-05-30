package com.example.thrones.domain.useCases

import com.example.thrones.data.ThronesRepository
import com.example.thrones.data.di.IODispatcher
import com.example.thrones.domain.data.models.CharacterInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repository: ThronesRepository,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(id: Int): CharacterInfo{
        return withContext(dispatcher){
            return@withContext repository.getCharacter(id).let {
                CharacterInfo(
                    id= it.id,
                    title = it.title,
                    family = it.family,
                    fullName = it.fullName,
                    imageUrl = it.imageUrl
                )
            }
        }
    }
}