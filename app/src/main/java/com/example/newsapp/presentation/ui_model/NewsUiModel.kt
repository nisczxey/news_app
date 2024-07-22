package com.example.newsapp.presentation.ui_model

import com.example.newsapp.domain.model.NewsEntity

data class NewsUiModel(
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String?
)

fun NewsEntity.toUi() = NewsUiModel(
    author = author,
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    content = content
)