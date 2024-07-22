package com.example.newsapp.presentation.fragments.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.common.Resource
import com.example.newsapp.domain.use_case.GetNewsListUseCase
import com.example.newsapp.presentation.state.NewsListState
import com.example.newsapp.presentation.ui_model.toUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNewsListUseCase: GetNewsListUseCase
) : ViewModel() {

    private val _state = MutableLiveData<NewsListState>()
    val state: LiveData<NewsListState>
        get() = _state

    init {
        getNewsList()
    }

    private fun getNewsList() {
        getNewsListUseCase().onEach { result ->
            when (result) {
                is Resource.Success ->
                    _state.value = NewsListState(
                        result.data?.map {
                            it.toUi()
                        } ?: emptyList())

                is Resource.Loading ->
                    _state.value = NewsListState(isLoading = true)

                is Resource.Error ->
                    _state.value = NewsListState(error = result.message.toString())
            }
        }.launchIn(viewModelScope)
    }

}