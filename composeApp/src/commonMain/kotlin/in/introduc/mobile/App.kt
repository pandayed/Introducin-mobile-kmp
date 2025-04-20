package `in`.introduc.mobile

import BottomNavBar
import FeedScreen

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import postModule

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import `in`.introduc.mobile.presentation.screens.home.HomeScreen


sealed class AppScreen(val route: String) {
    object Home : AppScreen("home")
    object Account : AppScreen("account")
    object Profile : AppScreen("profile")
    object SignIn : AppScreen("signin")
}

@Composable
@Preview
fun App() {

    startKoin {
        printLogger(Level.DEBUG)
        modules(postModule)
    }

    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.padding(top = 24.dp), // Add padding for the status bar
    ) {
        NavHost(navController = navController, startDestination = AppScreen.Home.route) {
            composable(AppScreen.Home.route) { HomeScreen() }
            composable(AppScreen.Account.route) { Text("Account Screen") }
            composable(AppScreen.Profile.route) { Text("Profile Screen") }
            composable(AppScreen.SignIn.route) { Text("SignIn Screen") }
        }
    }
}