import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NotificationsScreen(paddingValues: PaddingValues) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Notifications Screen")
    }
}