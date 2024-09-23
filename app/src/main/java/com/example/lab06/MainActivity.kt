package com.example.lab06

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.ui.graphics.Color

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
        // Barra superior
        topBar = { CustomTopBar(navController) },
        // Barra inferior
        bottomBar = { CustomBottomBar(navController) },
        // Botón flotante personalizado
        floatingActionButton = {
            CustomFAB(onClick = { clickCount++ })
        },
        // Contenido principal
        content = { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "main",
                modifier = Modifier.padding(innerPadding)
            ) {
                composable("main") {
                    MainScreen() // Pantalla principal básica
                }
                composable("profile") {
                    UserProfileScreen() // Pantalla de perfil
                }
                composable("menu") {
                    MenuScreen() // Pantalla de menú
                }
            }
        }
    )
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

@Composable
fun MainScreen() {
    // Pantalla principal sencilla
    Text(
        text = "Pantalla Principal",
        modifier = Modifier.padding(16.dp),
        fontSize = 20.sp
    )
}
