package com.example.thrones.presentation.characterDetails

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thrones.data.ThronesRepository
import com.example.thrones.data.di.MainDispatcher
import com.example.thrones.data.remote.CharacterInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    @MainDispatcher private val dispatcher: CoroutineDispatcher,
    private val thronesRepository: ThronesRepository,
    stateHandle: SavedStateHandle
) : ViewModel(){
    private val _state = mutableStateOf(
        CharacterDetailScreenState(
            characterInfo = null,
            isLoading = true
        )
    )
    val state get() = _state

    private val exception = CoroutineExceptionHandler { _, throwable ->
        _state.value = _state.value.copy(
            error = throwable.localizedMessage
        )
    }

    init {
        viewModelScope.launch(dispatcher + exception) {
            val id = stateHandle.get<Int>("id")?:0
            val person = getCharacter(id)
            _state.value = _state.value.copy(
                characterInfo = person,
                isLoading = false
            )
        }
    }
    private suspend fun getCharacter(id:Int): CharacterInfo{
        return thronesRepository.getCharacter(id)
    }
}