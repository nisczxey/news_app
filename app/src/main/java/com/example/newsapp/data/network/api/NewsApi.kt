package com.example.newsapp.data.network.api

import androidx.annotation.IntRange
import com.example.newsapp.data.network.api.interceptor.NewsInterceptor
import com.example.newsapp.data.network.model.ResponseDto
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("/v2/everything")
    suspend fun getNewsList(
        @Query("q") query: String? = "Android",
        @Query("from") from: String? = "2024-07-21",
        @Query("to") to: String? = "2024-07-21",
        @Query("sortBy") sortBy: String? = "publishedAt",
        @Query("language") language: String? = "ru",
        @Query("pageSize") @IntRange(from = 0, to = 50) pageSize: Int = 50,
        @Query("page") @IntRange(from = 1) page:Int = 1
    ): ResponseDto
}

fun NewsApi(
    baseUrl: String,
    apiKey: String
): NewsApi {
    val retrofit = retrofitBuild(baseUrl, apiKey)
    return retrofit.create(NewsApi::class.java)
}

private fun retrofitBuild(baseUrl: String, apiKey: String): Retrofit {

    val client = OkHttpClient.Builder()
        .addInterceptor(NewsInterceptor(apiKey))
        .build()

    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}