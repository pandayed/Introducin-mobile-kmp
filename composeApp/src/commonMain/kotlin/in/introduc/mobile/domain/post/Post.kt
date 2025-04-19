data class Post(
    val id: String,
    val authorName: String,
    val authorHandle: String,
    val content: String,
    val timestamp: Long,
    val profileImageUrl: String? = null
)