package com.example.thrones

import com.example.thrones.domain.data.ThronesRepositoryImpl
import com.example.thrones.domain.useCases.GetAllCharactersUseCase
import com.example.thrones.presentation.characterList.CharacterListScreenState
import com.example.thrones.presentation.characterList.CharacterListViewModel
import com.example.thrones.utils.DummyContent
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Test

class CharacterListViewModelTest {
    private val dispatcher = StandardTestDispatcher()
    private val scope = TestScope(dispatcher)

    @Test
    fun initialState_isProduced() = scope.runTest {
        val viewModel = getCharacterViewModel()
        val currentState = viewModel.state.value

        assert(
            currentState == CharacterListScreenState(
                chars = emptyList(),
                isLoading = true,
                error = null
            )
        )
    }
    @Test
    fun stateWithContent_isProduced() = scope.runTest {
        val viewModel = getCharacterViewModel()
        advanceUntilIdle()
        val state = viewModel.state.value

        assert(state == CharacterListScreenState(
            chars = DummyContent.getDomainCharacters(),
            isLoading = false,
            error = null
        ))
    }

    fun getCharacterViewModel(): CharacterListViewModel{
        val repository = ThronesRepositoryImpl(FakeApiService(),dispatcher)
        val getAllCharactersUseCase = GetAllCharactersUseCase(repository,dispatcher)
        return CharacterListViewModel(dispatcher,getAllCharactersUseCase)
    }
}