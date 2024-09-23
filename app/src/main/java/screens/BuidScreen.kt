package com.example.lab06.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BuildScreen() {
    Log.d("Navigation", "BuildScreen displayed")

    // Contenedor principal
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Column para organizar el contenido
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Configuraciones",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 24.dp)
            )
            Text(
                text = "Esta es la pantalla donde se haran configuraciones para la app.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}
