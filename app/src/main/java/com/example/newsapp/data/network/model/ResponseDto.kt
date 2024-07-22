package com.example.newsapp.data.network.model

import com.google.gson.annotations.SerializedName

data class ResponseDto(
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int,
    @SerializedName("articles")
    val articles: List<NewsDto>
)
