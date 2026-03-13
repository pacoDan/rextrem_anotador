package com.rextrem.anotador

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.rextrem.anotador.data.repository.InMemoryNoteRepository
import com.rextrem.anotador.presentation.navigation.NavGraph
import com.rextrem.anotador.ui.theme.AnotadorTheme

class MainActivity : ComponentActivity() {

    // Para demo. En producción: DI (Hilt/Koin) + singleton apropiado
    private val repository = InMemoryNoteRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnotadorTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController, repository = repository)
            }
        }
    }
}