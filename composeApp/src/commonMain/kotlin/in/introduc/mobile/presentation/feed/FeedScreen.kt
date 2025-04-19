import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview


import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*

@Composable
fun FeedScreen(viewModel: FeedViewModel = koinViewModel()) {

    val posts by viewModel.posts.collectAsState()

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { /* handle post refresh if needed */ }) {
            Text("Load Posts")
        }

        posts.forEach { post ->
            Text(text = post.content)
        }
    }
}
