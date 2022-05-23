package com.example.stringreducto.presentation.input_screen.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun VerifyWordButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("Reduzir")
    }
}