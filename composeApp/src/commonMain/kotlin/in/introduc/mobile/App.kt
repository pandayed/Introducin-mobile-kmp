package `in`.introduc.mobile

import BottomNavBar
import FeedScreen

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import introducin_mobile.composeapp.generated.resources.Res
import introducin_mobile.composeapp.generated.resources.compose_multiplatform
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import postModule

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp


@Composable
@Preview
fun App() {

    startKoin {
        printLogger(Level.DEBUG)
        modules(postModule)
    }

    var currentRoute by remember { mutableStateOf(Screen.Feed.route) }

    Scaffold(
        modifier = Modifier.padding(top = 24.dp), // Add padding for the status bar
        topBar = {
            TopAppBar(
                title = { Text("App Title") },
                actions = {
                    IconButton(onClick = { /* Handle profile icon click */ }) {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "Profile Icon",
                            tint = Color.White
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomNavBar(
                currentRoute = currentRoute,
                onItemSelected = { screen -> currentRoute = screen.route }
            )
        }
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            when (currentRoute) {
                Screen.Feed.route -> FeedScreen()
                Screen.Trending.route -> Text("Trending Screen") // Replace with actual composable
                Screen.Notifications.route -> Text("Notifications Screen") // Replace with actual composable
            }
        }
    }
}