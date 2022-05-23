package com.example.stringreducto.presentation.input_screen.components

import androidx.compose.material.TextField
import androidx.compose.runtime.Composable

@Composable
fun DefaultTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = onValueChange
    )
}