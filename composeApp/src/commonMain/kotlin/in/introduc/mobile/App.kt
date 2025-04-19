package `in`.introduc.mobile

import FeedScreen

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import appModule
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import introducin_mobile.composeapp.generated.resources.Res
import introducin_mobile.composeapp.generated.resources.compose_multiplatform
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

@Composable
@Preview
fun App() {

    startKoin {
        printLogger(Level.DEBUG)
        modules(appModule)
    }

    FeedScreen()
}