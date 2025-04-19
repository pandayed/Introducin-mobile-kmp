import `in`.introduc.mobile.domain.post.IPostRepository
import kotlinx.coroutines.flow.Flow

class GetPostsUseCase(private val repository: IPostRepository) {
    suspend fun execute(): Flow<List<Post>> {
        return repository.getPosts()
    }
}