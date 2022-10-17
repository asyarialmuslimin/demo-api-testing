package com.saifur.demoapitesting.domain.usecase

import com.saifur.demoapitesting.domain.repository.IPostRepository

class PostInteractor(private val iPostRepository: IPostRepository) : PostUseCase {
    override fun getPost() = iPostRepository.getPost()

    override fun createPost(title: String, body: String) =
        iPostRepository.createPost(title, body)
}