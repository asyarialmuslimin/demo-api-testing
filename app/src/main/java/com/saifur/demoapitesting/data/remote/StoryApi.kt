package com.saifur.demoapitesting.data.remote

import com.saifur.demoapitesting.utils.Const
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object StoryApi {
    private fun getRetrofit() : Retrofit {
        val interceptor = run {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        }

        val client = OkHttpClient.Builder()
            .addNetworkInterceptor(interceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .client(client)
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService(): ApiService = getRetrofit().create(ApiService::class.java)
}