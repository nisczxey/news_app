package com.example.newsapp.di

import com.example.newsapp.BuildConfig
import com.example.newsapp.common.Constants.BASE_URL
import com.example.newsapp.data.network.api.NewsApi
import com.example.newsapp.data.repository.NewsRepositoryImpl
import com.example.newsapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return NewsApi(
            BASE_URL,
            BuildConfig.API_KEY
        )
    }

    @Provides
    @Singleton
    fun provideRepository(api: NewsApi): NewsRepository = NewsRepositoryImpl(api)

}