package com.example.thrones

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.SavedStateViewModelFactory
import com.example.thrones.domain.data.ThronesRepositoryImpl
import com.example.thrones.domain.useCases.GetCharacterUseCase
import com.example.thrones.presentation.characterDetails.CharacterDetailScreenState
import com.example.thrones.presentation.characterDetails.CharacterDetailsViewModel
import com.example.thrones.utils.DummyContent
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Test

class CharacterDetailsViewModelTest {
    private val dispatcher = StandardTestDispatcher()
    private val testScope = TestScope(dispatcher)

    @Test
    fun initialState_isInitialized() = testScope.runTest{
        val vm = getCharacterDetailsViewModel()
        val currentState = vm.state.value

        assert(currentState == CharacterDetailScreenState(
            characterInfo = null,
            isLoading = true,
            error = null
        ))
    }
    @Test
    fun stateWithContent_isProduced()=testScope.runTest{
        val getCharacterDetailsViewModel = getCharacterDetailsViewModel()
        advanceUntilIdle()
        val currentState = getCharacterDetailsViewModel.state.value

        assert(currentState == CharacterDetailScreenState(
            characterInfo = DummyContent.getDomainCharacters().get(0),
            isLoading = false
        ))
    }

    private fun getCharacterDetailsViewModel(): CharacterDetailsViewModel{
        val repository = ThronesRepositoryImpl(FakeApiService(),dispatcher)
        val getCharacterUseCase = GetCharacterUseCase(repository,dispatcher)
        val stateHandle = SavedStateHandle.createHandle(restoredState = null,defaultState = null)
        return CharacterDetailsViewModel(dispatcher,getCharacterUseCase,stateHandle)
    }

}