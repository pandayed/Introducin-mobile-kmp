import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Person
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Star

@Composable
fun FeedScreen(viewModel: FeedViewModel = koinInject()) {
    val posts by viewModel.posts.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(1.dp) // <-- this is like gap
    ) {
        items(posts) { post ->
            PostItem(
                authorName = post.authorName,
                authorHandle = post.authorHandle,
                content = post.content
            )
        }
    }
}

@Composable
fun PostItem(authorName: String, authorHandle: String, content: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "Profile Placeholder",
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 8.dp)
                    .clip(CircleShape),
                tint = Color.Gray
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
            Text(
                text = "2h ago", // Replace with dynamic timestamp if available
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
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
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Like",
                    tint = Color.Gray
                )
            }
            IconButton(onClick = { /* No functionality */ }) {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Comment",
                    tint = Color.Gray
                )
            }
            IconButton(onClick = { /* No functionality */ }) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = "Share",
                    tint = Color.Gray
                )
            }
            IconButton(onClick = { /* No functionality */ }) {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Report",
                    tint = Color.Gray
                )
            }
            IconButton(onClick = { /* No functionality */ }) {
                Icon(
                    imageVector = Icons.Filled.Refresh,
                    contentDescription = "Reshare",
                    tint = Color.Gray
                )
            }
            IconButton(onClick = { /* No functionality */ }) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Save",
                    tint = Color.Gray
                )
            }
        }
    }
}
