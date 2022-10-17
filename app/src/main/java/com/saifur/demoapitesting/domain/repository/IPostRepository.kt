package com.saifur.demoapitesting.domain.repository

import com.saifur.demoapitesting.data.remote.response.CreatePostResponse
import com.saifur.demoapitesting.data.remote.response.PostResponseItem
import com.saifur.demoapitesting.utils.Resource
import kotlinx.coroutines.flow.Flow

interface IPostRepository {
    fun getPost() : Flow<Resource<List<PostResponseItem>>>
    fun createPost(title:String, body:String) : Flow<Resource<CreatePostResponse>>
}