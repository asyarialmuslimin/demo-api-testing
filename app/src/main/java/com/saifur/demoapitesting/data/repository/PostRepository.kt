package com.saifur.demoapitesting.data.repository

import com.saifur.demoapitesting.data.remote.ApiService
import com.saifur.demoapitesting.data.remote.response.CreatePostRequest
import com.saifur.demoapitesting.data.remote.response.CreatePostResponse
import com.saifur.demoapitesting.data.remote.response.PostResponseItem
import com.saifur.demoapitesting.domain.repository.IPostRepository
import com.saifur.demoapitesting.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PostRepository(private val apiService: ApiService) : IPostRepository {
    override fun getPost(): Flow<Resource<List<PostResponseItem>>> {
        return flow {
            emit(Resource.loading(null))
            try {
                val response = apiService.getPost()
                emit(Resource.success(response))
            } catch (e:Exception) {
                e.printStackTrace()
                emit(Resource.error("", null))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun createPost(title: String, body: String): Flow<Resource<CreatePostResponse>> {
        return flow {
            emit(Resource.loading(null))
            try {
                val request = CreatePostRequest(title, body, 1)
                val response = apiService.submitPost(request)
                emit(Resource.success(response))
            } catch (e:Exception) {
                e.printStackTrace()
                emit(Resource.error("", null))
            }
        }.flowOn(Dispatchers.IO)
    }

}