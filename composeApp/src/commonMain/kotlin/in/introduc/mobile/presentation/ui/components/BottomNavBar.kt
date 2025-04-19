

import Screen
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings

@Composable
fun BottomNavBar(
    currentRoute: String,
    onItemSelected: (Screen) -> Unit
) {
    val items = listOf(
        Screen.Feed to Icons.Filled.Home,
        Screen.Trending to Icons.Filled.Settings,
        Screen.Notifications to Icons.Filled.Notifications
    )

    BottomNavigation {
        items.forEach { (screen, icon) ->
            BottomNavigationItem(
                selected = currentRoute == screen.route,
                onClick = { onItemSelected(screen) },
                icon = { Icon(imageVector = icon, contentDescription = screen.label) },
                label = { Text(screen.label) }
            )
        }
    }
}
