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
fun FavoriteScreen() {
    Log.d("Navigation", "Navigating to favorite")

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
                text = "Rutas Favoritas",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 24.dp)
            )
            Text(
                text = "Aquí puedes ver tus elementos favoritos.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Aún no tienes favoritos guardados.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
