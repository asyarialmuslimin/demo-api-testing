package com.saifur.demoapitesting.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.saifur.demoapitesting.domain.usecase.PostUseCase

class PostViewModel(private val postUseCase: PostUseCase) : ViewModel() {
    fun getStory() = postUseCase.getPost().asLiveData()
    fun createStory(title:String, description:String) = postUseCase.createPost(title, description).asLiveData()
}