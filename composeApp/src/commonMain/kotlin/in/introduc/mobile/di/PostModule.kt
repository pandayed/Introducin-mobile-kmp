import GetPostsUseCase
import PostRepository
import `in`.introduc.mobile.domain.post.IPostRepository

import org.koin.dsl.module

val postModule = module {

    // Provide repository
    single<IPostRepository> { PostRepository() }

    // Provide use case
    single { GetPostsUseCase(get()) }
}