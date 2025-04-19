import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject

@Composable
fun FeedScreen(viewModel: FeedViewModel = koinInject()) {
    val posts by viewModel.posts.collectAsState()

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { /* handle post refresh if needed */ }) {
            Text("Load Posts")
        }

        posts.forEach { post ->
            PostItem(
                profileImage = painterResource(id = post.profileImageRes),
                authorName = post.authorName,
                authorHandle = post.authorHandle,
                content = post.content
            )
        }
    }
}

@Composable
fun PostItem(profileImage: Painter, authorName: String, authorHandle: String, content: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = profileImage,
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 8.dp)
                    .clip(CircleShape)
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = authorName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = authorHandle,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
            IconButton(onClick = { /* No functionality */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_more_vert),
                    contentDescription = "Menu"
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = content,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { /* No functionality */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_like),
                    contentDescription = "Like",
                    tint = Color.Gray
                )
            }
            IconButton(onClick = { /* No functionality */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_comment),
                    contentDescription = "Comment",
                    tint = Color.Gray
                )
            }
            IconButton(onClick = { /* No functionality */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_share),
                    contentDescription = "Share",
                    tint = Color.Gray
                )
            }
        }
    }
}
