import `in`.introduc.mobile.domain.post.IPostRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module {
    // Define the PostRepository as a singleton
    single<IPostRepository> { PostRepository() }

    // Define the GetPostsUseCase as a singleton
    single { GetPostsUseCase(get()) }
}