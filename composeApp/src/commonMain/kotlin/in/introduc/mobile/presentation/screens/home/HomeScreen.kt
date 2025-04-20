package `in`.introduc.mobile.presentation.screens.home

import FeedScreen
import HomeBottomNavBar
import HomeNavigationHost
import `in`.introduc.mobile.presentation.screens.home.navigation.HomeScreenRoute
import MessagesScreen
import NotificationsScreen
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class HomeNavigationActions(private val navController: NavHostController) {
    fun navigateTo(route: HomeScreenRoute) {
        navController.navigate(route.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}

@Composable
fun HomeScreen(

) {
    val navController = rememberNavController()
    val navigationActions = remember(navController) {
        HomeNavigationActions(navController)
    }

    Scaffold(
        bottomBar = { 
            HomeBottomNavBar(
                navController = navController,
                navigationActions = navigationActions
            ) 
        }
    ) { paddingValues ->
        HomeNavigationHost(
            navController = navController,
            paddingValues = paddingValues,

        )
    }
}



@Composable
fun HomeScreenContent(
    route: String,
    paddingValues: PaddingValues,
    backStackEntry: NavBackStackEntry
) {
    when (HomeScreenRoute.fromRoute(route)) {
        HomeScreenRoute.Feed -> {
            FeedScreen(
                paddingValues = paddingValues,
            )
        }
        HomeScreenRoute.Messages -> {
            MessagesScreen(
                paddingValues = paddingValues,

            )
        }
        HomeScreenRoute.Notifications -> {
            NotificationsScreen(
                paddingValues = paddingValues,

            )
        }
        else -> {
            FeedScreen(
                paddingValues = paddingValues,
            )
        }
    }
}
