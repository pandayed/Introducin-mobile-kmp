package `in`.introduc.mobile.domain.post

import Post

interface IPostRepository {
    suspend fun getPosts(): List<Post>
}