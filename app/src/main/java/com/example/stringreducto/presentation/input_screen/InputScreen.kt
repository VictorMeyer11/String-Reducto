package com.example.stringreducto.presentation.input_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    val resultText = uiState.outputText

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
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultTextField(
                value = text,
                onValueChange = {
                    viewModel.dispatchEvent(event = InputScreenUIEvent.TextInputted(it))
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            VerifyWordButton(onClick = {
                viewModel.dispatchEvent(event = InputScreenUIEvent.VerifyInput)
            })
            Spacer(modifier = Modifier.height(10.dp))
            Text("String resultante: $resultText")
        }
    }
}