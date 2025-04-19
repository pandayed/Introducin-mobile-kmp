import `in`.introduc.mobile.domain.post.IPostRepository
import `in`.introduc.mobile.data.PostDataSource

class PostRepository : IPostRepository {
    override suspend fun getPosts(): List<Post> {
        return PostDataSource.getFakePosts()
    }
}