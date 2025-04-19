import `in`.introduc.mobile.domain.post.IPostRepository
import `in`.introduc.mobile.data.PostDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PostRepository : IPostRepository {
    override suspend fun getPosts(): Flow<List<Post>> {
        return flow { emit(PostDataSource.getFakePosts()) }
    }
}