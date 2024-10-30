package com.example.newsgenz.model.retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    //dd4c381d3a28438da2f2546ec1d99539

    @GET("v2/top-headlines")
    suspend fun getEveryNews(
        @Query("country") country: String = "us",
        @Query("page") pageNumber:Int = 1,
        @Query("apiKey") key: String = "dd4c381d3a28438da2f2546ec1d99539"
    ):Response<NewsResponse>


    @GET("v2/top-headlines")
    suspend fun getTopHeadline(
        @Query("country") country: String = "Us",
        @Query("category") category: String = "business",
        @Query("apiKey")key: String="dd4c381d3a28438da2f2546ec1d99539"
    ):Response<NewsResponse>
}

