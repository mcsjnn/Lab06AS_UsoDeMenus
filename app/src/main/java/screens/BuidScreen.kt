package com.example.lab06.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BuildScreen() {
    Log.d("Navigation", "BuildScreen displayed")
    Text(
        text = "Build Screen",
        modifier = Modifier.fillMaxSize()
    )
}