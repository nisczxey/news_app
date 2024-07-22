package com.example.newsapp.data.network.model

import com.example.newsapp.domain.model.NewsEntity
import com.google.gson.annotations.SerializedName

data class NewsDto(
    @SerializedName("source")
    val source: SourceDto,
    @SerializedName("author")
    val author: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description:String?,
    @SerializedName("url")
    val url: String,
    @SerializedName("urlToImage")
    val urlToImage: String,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("content")
    val content: String?
)

fun NewsDto.toEntity() = NewsEntity(
    author = author,
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    content = content
)