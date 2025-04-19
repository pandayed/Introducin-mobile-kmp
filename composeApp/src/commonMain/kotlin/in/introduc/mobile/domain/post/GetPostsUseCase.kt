import `in`.introduc.mobile.domain.post.IPostRepository

class GetPostsUseCase(private val repository: IPostRepository) {
    suspend fun execute(): List<Post> {
        return repository.getPosts()
    }
}