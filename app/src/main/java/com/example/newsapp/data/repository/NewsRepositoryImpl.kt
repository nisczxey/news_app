package com.example.newsapp.data.repository

import android.util.Log
import com.example.newsapp.data.network.api.NewsApi
import com.example.newsapp.data.network.model.toEntity
import com.example.newsapp.domain.model.NewsEntity
import com.example.newsapp.domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val api: NewsApi
) : NewsRepository {

    override suspend fun getNewsDetails(): NewsEntity {
        TODO("Not yet implemented")
    }

    override suspend fun getNewsList(): List<NewsEntity> {
        return api.getNewsList().articles.map { it.toEntity() }
    }

}