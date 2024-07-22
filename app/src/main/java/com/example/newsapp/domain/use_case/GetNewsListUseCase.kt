package com.example.newsapp.domain.use_case

import com.example.newsapp.common.Resource
import com.example.newsapp.domain.model.NewsEntity
import com.example.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetNewsListUseCase(
    private val repository: NewsRepository
) {

    operator fun invoke(): Flow<Resource<List<NewsEntity>>> = flow {
        try {
            emit(Resource.Loading())
            val data = repository.getNewsList()
            emit(Resource.Success(data))
        } catch (e: HttpException) {
            emit(Resource.Error(e.toString()))
        } catch (_: IOException) {
            emit(Resource.Error("check internet connection"))
        }
    }
}