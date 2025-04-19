import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.mp.KoinPlatform.getKoin


@Composable
fun FeedScreen() {
    // Retrieve the GetPostsUseCase from Koin
    val getPostsUseCase: GetPostsUseCase = getKoin().get()

    // State to hold posts
    val posts = produceState(initialValue = emptyList<Post>()) {
        value = getPostsUseCase.execute()
    }

    // UI to display posts
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { /* Trigger action to update posts */ }) {
            Text("Load Posts")
        }

        // Display the posts
        posts.value.forEach { post ->
            Text(text = post.content) // Assuming Post has a 'content' property
        }
    }
}
@Preview
@Composable
fun PreviewFeedScreen() {
    FeedScreen() // Preview FeedScreen with mock data
}
