package com.example.thrones.presentation.characterList

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thrones.data.ThronesRepository
import com.example.thrones.data.di.MainDispatcher
import com.example.thrones.data.remote.CharacterInfoDto
import com.example.thrones.domain.data.models.CharacterInfo
import com.example.thrones.domain.useCases.GetAllCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    @MainDispatcher private val dispatcher: CoroutineDispatcher,
    private val getAllCharactersUseCase: GetAllCharactersUseCase
):ViewModel() {
    private val _state = mutableStateOf(CharacterListScreenState(
        chars = emptyList(),
        isLoading = true
    ))
    val state get()=_state

    val exception = CoroutineExceptionHandler { _, throwable ->
        _state.value = _state.value.copy(
            chars = emptyList(),
            isLoading = false,
            error = throwable.localizedMessage
        )
    }

    init {
        viewModelScope.launch(dispatcher + exception) {
            val chars = getCharacters()
            _state.value = _state.value.copy(
                chars = chars,
                isLoading = false
            )
        }
    }
    private suspend fun getCharacters():List<CharacterInfo>{
        return getAllCharactersUseCase()
    }
}