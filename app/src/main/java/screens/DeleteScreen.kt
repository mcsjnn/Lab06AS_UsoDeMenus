package com.example.lab06.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DeleteScreen(onDeleteConfirmed: () -> Unit) {
    Log.d("Navigation", "Navigating to delete")

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier.padding(16.dp).fillMaxWidth(0.9f),
            shape = MaterialTheme.shapes.medium
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Eliminar Elemento",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "¿Estás seguro de que deseas eliminar este elemento?",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Button(onClick = {
                    onDeleteConfirmed() // Llamada a la función de confirmación
                }) {
                    Text("Confirmar Eliminación")
                }
            }
        }
    }
}
