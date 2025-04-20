package `in`.introduc.mobile.presentation.screens.home.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

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
