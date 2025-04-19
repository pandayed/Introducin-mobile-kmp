package `in`.introduc.mobile.domain.post

import Post
import kotlinx.coroutines.flow.Flow

interface IPostRepository {
    suspend fun getPosts(): Flow<List<Post>>
}