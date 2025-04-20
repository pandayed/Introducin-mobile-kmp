
sealed class Screen(val route: String, val label: String) {
    object Feed : Screen("feed", "Feed")
    object Trending : Screen("settings", "Settings")
    object Notifications : Screen("notifications", "Notifications")
}