package com.example.stringreducto.presentation.input_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stringreducto.presentation.input_screen.components.DefaultTextField
import com.example.stringreducto.presentation.input_screen.components.VerifyWordButton
import kotlinx.coroutines.flow.collect

@Composable
fun InputScreen(
    viewModel: InputScreenViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val uiState by viewModel.uiState.collectAsState()
    val text = uiState.inputText

    LaunchedEffect(key1 = Unit) {
        viewModel.uiAction.collect { action ->
            when (action) {
                is InputScreenUIAction.ShowErrorToast -> {
                    scaffoldState.snackbarHostState.showSnackbar("Input inválido!")
                }
            }
        }
    }

    Scaffold(scaffoldState = scaffoldState) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            DefaultTextField(
                value = text,
                onValueChange = {
                    viewModel.dispatchEvent(event = InputScreenUIEvent.TextInputted(it))
                }
            )
            VerifyWordButton(onClick = {
                viewModel.dispatchEvent(event = InputScreenUIEvent.VerifyInput)
            })
        }
    }
}