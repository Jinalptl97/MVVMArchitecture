package com.example.mvvm_arch.data.repository

import com.example.mvvm_arch.data.api.NetworkService
import com.example.mvvm_arch.data.model.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TopHeadlineRepository @Inject constructor(private val networkService: NetworkService) {
    fun getTopHeadlines(country: String): Flow<List<Article>> {
        return flow {
            emit(networkService.gettopheadlines(country))
        }.map {
            it.articles
        }
    }

}