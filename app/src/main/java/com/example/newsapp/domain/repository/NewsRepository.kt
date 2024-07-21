package com.example.newsapp.domain.repository

import com.example.newsapp.domain.model.NewsEntity

interface NewsRepository {

    suspend fun getNewsDetails(): NewsEntity

    suspend fun getNewsList(): List<NewsEntity>
}