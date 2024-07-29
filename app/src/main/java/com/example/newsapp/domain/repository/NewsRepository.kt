package com.example.newsapp.domain.repository

import com.example.newsapp.domain.model.NewsEntity

interface NewsRepository {

    suspend fun getNewsList(): List<NewsEntity>

}