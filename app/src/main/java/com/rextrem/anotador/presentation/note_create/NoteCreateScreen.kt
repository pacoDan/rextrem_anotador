package com.rextrem.anotador.presentation.note_create

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteCreateScreen(
    viewModel: NoteCreateViewModel,
    onBack: () -> Unit
) {
    val text by viewModel.text.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Nueva nota") },
                navigationIcon = {
                    TextButton(onClick = onBack) { Text("Atrás") }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = viewModel::onTextChange,
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Escribe tu nota") }
            )

            Button(
                onClick = { viewModel.save(onSaved = onBack) },
                modifier = Modifier.fillMaxWidth(),
                enabled = text.isNotBlank()
            ) {
                Text("Guardar")
            }
        }
    }
}