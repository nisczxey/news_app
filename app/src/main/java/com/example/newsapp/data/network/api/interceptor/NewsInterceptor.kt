package com.example.newsapp.data.network.api.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class NewsInterceptor(private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder().header("X-Api-Key", apiKey)
            .build()
        return chain.proceed(request)
    }
}