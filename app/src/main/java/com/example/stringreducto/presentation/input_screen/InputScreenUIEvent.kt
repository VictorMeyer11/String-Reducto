package com.example.stringreducto.presentation.input_screen

sealed interface InputScreenUIEvent {
    object VerifyInput: InputScreenUIEvent
    data class TextInputted(val text: String): InputScreenUIEvent
}