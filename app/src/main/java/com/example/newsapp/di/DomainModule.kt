package com.example.newsapp.di

import com.example.newsapp.domain.repository.NewsRepository
import com.example.newsapp.domain.use_case.GetNewsDetailUseCase
import com.example.newsapp.domain.use_case.GetNewsListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetNewsListUseCase(
        repository: NewsRepository
    ) : GetNewsListUseCase = GetNewsListUseCase(repository)

    @Provides
    fun provideGetNewsDetailUseCase(
        repository: NewsRepository
    ) : GetNewsDetailUseCase = GetNewsDetailUseCase()
}