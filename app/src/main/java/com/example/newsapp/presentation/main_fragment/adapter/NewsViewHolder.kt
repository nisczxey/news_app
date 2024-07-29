package com.example.newsapp.presentation.main_fragment.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.newsapp.databinding.ItemNewsListBinding
import com.example.newsapp.presentation.ui_model.NewsUiModel

class NewsViewHolder(
    private val binding: ItemNewsListBinding
) : ViewHolder(binding.root) {
    fun bind(news: NewsUiModel) {
        binding.tvTitle.text = news.title
        Glide.with(binding.root).load(news.urlToImage).into(binding.img)
    }
}