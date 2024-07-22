package com.example.newsapp.presentation.state

import com.example.newsapp.presentation.ui_model.NewsUiModel

data class NewsListState(
    val news: List<NewsUiModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
