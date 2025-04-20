package `in`.introduc.mobile.presentation.screens.home

import FeedScreen
import MessagesScreen
import NotificationsScreen
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Sealed class representing all possible navigation routes in the Home section
 */
sealed class HomeScreenRoute(val route: String, val label: String, val icon: ImageVector) {
    object Feed : HomeScreenRoute("feed", "Feed", Icons.Filled.Home)
    object Messages : HomeScreenRoute("messages", "Messages", Icons.Filled.ShoppingCart)
    object Notifications : HomeScreenRoute("notifications", "Notifications", Icons.Filled.Notifications)

    companion object {
        fun fromRoute(route: String?): HomeScreenRoute {
            return when(route) {
                Feed.route -> Feed
                Messages.route -> Messages
                Notifications.route -> Notifications
                else -> Feed
            }
        }

        val screens = listOf(Feed, Messages, Notifications)
    }
}

/**
 * Class to encapsulate navigation actions for the Home screen
 */
class HomeNavigationActions(private val navController: NavHostController) {
    fun navigateTo(route: HomeScreenRoute) {
        navController.navigate(route.route) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
    }
}

/**
 * Main composable for the Home screen section of the app
 */
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

/**
 * Bottom navigation bar for the Home screen
 */
@Composable
fun HomeBottomNavBar(
    navController: NavHostController,
    navigationActions: HomeNavigationActions
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        HomeScreenRoute.screens.forEach { screen ->
            val selected = currentDestination?.hierarchy?.any { 
                it.route == screen.route 
            } == true
            
            BottomNavigationItem(
                selected = selected,
                onClick = { 
                    if (!selected) {
                        navigationActions.navigateTo(screen)
                    }
                },
                icon = { 
                    Icon(
                        imageVector = screen.icon, 
                        contentDescription = null
                    ) 
                },
                label = { Text(screen.label) },
                alwaysShowLabel = false
            )
        }
    }
}

/**
 * Navigation host for the Home screen section
 */
@Composable
fun HomeNavigationHost(
    navController: NavHostController,
    paddingValues: PaddingValues,

) {
    NavHost(
        navController = navController, 
        startDestination = HomeScreenRoute.Feed.route
    ) {
        HomeScreenRoute.screens.forEach { screen ->
            composable(screen.route) { backStackEntry ->
                HomeScreenContent(
                    route = screen.route,
                    paddingValues = paddingValues,
                    backStackEntry = backStackEntry
                )
            }
        }
    }
}

/**
 * Content displayed based on the current route
 */
@Composable
fun HomeScreenContent(
    route: String,
    paddingValues: PaddingValues,
    backStackEntry: NavBackStackEntry
) {
    // Use lazy composables or remember to avoid unnecessary recompositions
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
    }
}

/**
 * ViewModel that contains child ViewModels for each screen
 * This helps with sharing data between screens when needed
 */
class HomeViewModel {
    val feedViewModel = FeedViewModel()
    val messagesViewModel = MessagesViewModel() 
    val notificationsViewModel = NotificationsViewModel()
}

// Screen-specific ViewModels
class FeedViewModel
class MessagesViewModel
class NotificationsViewModel