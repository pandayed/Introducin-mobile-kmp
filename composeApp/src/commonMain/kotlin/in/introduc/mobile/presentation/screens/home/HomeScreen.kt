package `in`.introduc.mobile.presentation.screens.home

import FeedScreen
import MessagesScreen
import NotificationsScreen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { HomeBottomNavBar(navController) }
    ) { paddingValues -> // Pass paddingValues from Scaffold
        HomeNavigationHost(navController, paddingValues)
    }
}

@Composable
fun HomeBottomNavBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem("feed", "Feed", Icons.Filled.Home),
        BottomNavItem("messages", "Messages", Icons.Filled.ShoppingCart),
        BottomNavItem("notifications", "Notifications", Icons.Filled.Notifications)
    )

    BottomNavigation {
        val currentRoute = navController.currentDestination?.route
        items.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = { navController.navigate(item.route) },
                icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                label = { Text(item.label) }
            )
        }
    }
}

@Composable
fun HomeNavigationHost(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(navController, startDestination = "feed") {
        composable("feed") { FeedScreen(paddingValues = paddingValues) } // Pass paddingValues to FeedScreen
        composable("messages") { MessagesScreen() }
        composable("notifications") { NotificationsScreen() }
    }
}

data class BottomNavItem(val route: String, val label: String, val icon: androidx.compose.ui.graphics.vector.ImageVector)
