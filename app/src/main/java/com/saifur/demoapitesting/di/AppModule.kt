package com.saifur.demoapitesting.di

import com.saifur.demoapitesting.data.remote.StoryApi
import com.saifur.demoapitesting.data.repository.PostRepository
import com.saifur.demoapitesting.domain.repository.IPostRepository
import com.saifur.demoapitesting.domain.usecase.PostInteractor
import com.saifur.demoapitesting.domain.usecase.PostUseCase
import com.saifur.demoapitesting.viewmodel.PostViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory {
        StoryApi.getService()
    }
    factory<IPostRepository> { PostRepository(get()) }
    factory<PostUseCase> { PostInteractor(get()) }
}

val viewModelModule = module {
    viewModel {
        PostViewModel(get())
    }
}