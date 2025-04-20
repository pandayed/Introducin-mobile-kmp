import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import `in`.introduc.mobile.presentation.screens.home.HomeScreenContent
import `in`.introduc.mobile.presentation.screens.home.navigation.HomeScreenRoute

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