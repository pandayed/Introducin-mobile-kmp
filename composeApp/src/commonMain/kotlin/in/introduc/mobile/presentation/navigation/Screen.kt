
sealed class Screen(val route: String, val label: String) {
    object Feed : Screen("feed", "Feed")
    object Trending : Screen("trending", "Trending")
    object Notifications : Screen("notifications", "Notifications")
}