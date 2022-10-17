package com.saifur.demoapitesting.data.remote.response

data class CreatePostRequest(
    val title:String,
    val body:String,
    val userId:Int
)
