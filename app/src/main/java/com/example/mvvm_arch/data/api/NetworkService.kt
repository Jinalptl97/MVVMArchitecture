package com.example.mvvm_arch.data.api

import com.example.mvvm_arch.data.model.TopHeadlinesResponse
import com.example.mvvm_arch.utils.AppConstant.API_KEY
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NetworkService {

    @Headers("X-Api-key: $API_KEY")
    @GET("top-headlines")
    suspend fun gettopheadlines(@Query("country") country: String):TopHeadlinesResponse
}