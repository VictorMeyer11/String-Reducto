package com.example.stringreducto.presentation.input_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.stringreducto.domain.use_case.ReduceWord
import com.example.stringreducto.domain.use_case.VerifyInput
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InputScreenViewModel @Inject constructor(
    private val verifyInput: VerifyInput,
    private val reduceWord: ReduceWord
) : ViewModel() {
    private val _uiState: MutableStateFlow<InputScreenUIState> = MutableStateFlow(
        InputScreenUIState(
            inputText = "",
            outputText = ""
        )
    )
    private val _uiAction: MutableSharedFlow<InputScreenUIAction> = MutableSharedFlow()

    val uiState: StateFlow<InputScreenUIState> = _uiState
    val uiAction: SharedFlow<InputScreenUIAction> = _uiAction

    fun dispatchEvent(event: InputScreenUIEvent) {
        when (event) {
            is InputScreenUIEvent.TextInputted -> {
                _uiState.update {
                    it.copy(
                        inputText = event.text
                    )
                }
            }
            is InputScreenUIEvent.VerifyInput -> {
                val text = uiState.value.inputText

                if (verifyInput(text)) {
                    _uiState.update {
                        it.copy(
                            outputText = reduceWord(text)
                        )
                    }
                } else {
                    viewModelScope.launch {
                        _uiAction.emit(
                            value = InputScreenUIAction.ShowErrorToast
                        )
                    }
                }
            }
        }
    }
}