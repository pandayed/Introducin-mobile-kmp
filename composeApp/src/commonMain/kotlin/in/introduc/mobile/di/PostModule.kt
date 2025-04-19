import GetPostsUseCase
import PostRepository
import `in`.introduc.mobile.domain.post.IPostRepository

import org.koin.dsl.module

val postModule = module {

    single<IPostRepository> { PostRepository() }
    single { GetPostsUseCase(get()) }
    viewModel { FeedViewModel(get()) }
}