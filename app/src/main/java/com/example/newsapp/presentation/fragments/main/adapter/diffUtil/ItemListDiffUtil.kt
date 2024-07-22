package com.example.newsapp.presentation.fragments.main.adapter.diffUtil

import androidx.recyclerview.widget.DiffUtil
import com.example.newsapp.presentation.ui_model.NewsUiModel

class ItemListDiffUtil: DiffUtil.ItemCallback<NewsUiModel>() {
    override fun areItemsTheSame(
        oldItem: NewsUiModel,
        newItem: NewsUiModel
    ): Boolean = oldItem.title == newItem.title

    override fun areContentsTheSame(oldItem: NewsUiModel, newItem: NewsUiModel): Boolean =
        oldItem == newItem

}