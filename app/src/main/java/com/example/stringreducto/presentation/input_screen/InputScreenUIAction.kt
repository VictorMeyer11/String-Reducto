package com.example.stringreducto.presentation.input_screen

sealed interface InputScreenUIAction {
    object ShowErrorToast: InputScreenUIAction
}