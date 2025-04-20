import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import `in`.introduc.mobile.presentation.screens.home.HomeNavigationActions
import `in`.introduc.mobile.presentation.screens.home.navigation.HomeScreenRoute

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