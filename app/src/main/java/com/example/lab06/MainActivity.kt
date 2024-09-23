package com.example.lab06

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab06.screens.UserProfileScreen
import com.example.lab06.screens.MenuScreen
import com.example.lab06.ui.theme.Lab06Theme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.example.lab06.screens.BuildScreen
import com.example.lab06.screens.DeleteScreen
import com.example.lab06.screens.FavoriteScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab06Theme {
                CustomScaffold()
            }
        }
    }
}

@Composable
fun CustomScaffold() {
    val navController = rememberNavController()
    var clickCount by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = { CustomTopBar(navController) },
        bottomBar = { CustomBottomBar(navController) },
        floatingActionButton = {
            CustomFAB(onClick = { clickCount++ }) // Incrementar el contador al hacer clic
        },
        content = { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "main",
                modifier = Modifier.padding(innerPadding)
            ) {
                composable("main") {
                    CustomContent(padding = innerPadding, clickCount = clickCount) // Pasar el contador
                }
                composable("profile") { UserProfileScreen() }
                composable("menu") { MenuScreen() }
                composable("build") { BuildScreen() }
                composable("favorite") { FavoriteScreen() }
                composable("delete") {
                    DeleteScreen(onDeleteConfirmed = {
                        Log.d("Delete", "Elemento eliminado")
                    })
                }
            }
        }
    )
}

@Composable
fun CustomContent(padding: PaddingValues, clickCount: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Has presionado el botón $clickCount veces",
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(text = "My app content")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(navController: NavHostController) {
    TopAppBar(
        title = { Text(text = "GoGuía", style = MaterialTheme.typography.titleLarge) },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
        navigationIcon = {
            IconButton(onClick = { navController.navigate("menu") }) {
                Icon(imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu",
                    tint = Color.White)
            }
        },
        actions = {
            IconButton(onClick = { navController.navigate("profile") }) {
                Icon(imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Profile",
                    tint = Color.White)
            }
        }
    )
}


@Composable
fun CustomBottomBar(navController: NavHostController) {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = Color(0xFF6200EE) // Color principal
    ) {
        IconButton(
            onClick = { navController.navigate("build") },
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                Icons.Filled.Build,
                contentDescription = "Build description",
                tint = Color(0xFF6200EE))
        }
        IconButton(
            onClick = { navController.navigate("menu") },
            modifier = Modifier.weight(1f),
        ) {
            Icon(Icons.Filled.Menu,
                contentDescription = "Menu description",
                tint = Color(0xFF6200EE))
        }
        IconButton(
            onClick = { navController.navigate("favorite") },
            modifier = Modifier.weight(1f)
        ) {
            Icon(Icons.Filled.FavoriteBorder,
                contentDescription = "Favorites",
                tint = Color(0xFF6200EE))
        }
        IconButton(
            onClick = { navController.navigate("delete") },
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                Icons.Filled.Delete,
                contentDescription = "Delete description",
                tint = Color(0xFF6200EE))
        }
    }
}


@Composable
fun CustomFAB(onClick: () -> Unit) {
    FloatingActionButton(
        containerColor = MaterialTheme.colorScheme.primary,
        onClick = onClick,
        modifier = Modifier.padding(16.dp),
    ) {
        Text(
            fontSize = 24.sp,
            text = "+"
        )
    }
}


