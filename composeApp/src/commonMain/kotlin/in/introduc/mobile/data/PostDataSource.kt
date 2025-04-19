package `in`.introduc.mobile.data
import Post
import getCurrentTimeMillis

object PostDataSource {

    fun getFakePosts(): List<Post> {
        return listOf(
            Post(
                id = "1",
                authorName = "Alice",
                authorHandle = "@alice",
                content = "Hello, world! This is my first post.",
                timestamp = getCurrentTimeMillis(),
                profileImageUrl = null
            ),
            Post(
                id = "2",
                authorName = "Bob",
                authorHandle = "@bob",
                content = "Just had a great coffee. #morningvibes",
                timestamp = getCurrentTimeMillis(),
                profileImageUrl = null
            )
        )
    }
}