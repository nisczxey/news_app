package com.example.newsapp.presentation.fragments.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.newsapp.databinding.ItemNewsListBinding
import com.example.newsapp.presentation.fragments.main.adapter.diffUtil.ItemListDiffUtil
import com.example.newsapp.presentation.ui_model.NewsUiModel

class NewsAdapter : ListAdapter<NewsUiModel, NewsViewHolder>(ItemListDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val viewBinding = ItemNewsListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return NewsViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val newsItem = currentList[position]
        holder.bind(newsItem)
    }
}