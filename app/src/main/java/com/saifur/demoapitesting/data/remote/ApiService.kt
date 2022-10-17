package com.saifur.demoapitesting.data.remote

import com.saifur.demoapitesting.data.remote.response.CreatePostRequest
import com.saifur.demoapitesting.data.remote.response.CreatePostResponse
import com.saifur.demoapitesting.data.remote.response.PostResponseItem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("posts")
    suspend fun getPost() : List<PostResponseItem>

    @POST("posts")
    suspend fun submitPost(@Body body:CreatePostRequest) : CreatePostResponse
}