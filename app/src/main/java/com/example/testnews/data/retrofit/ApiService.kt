package com.example.testnews.data.retrofit

import com.example.testnews.data.model.NewsSource
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    fun getNews(@Query("country") country: String, @Query("apiKey") apiKey: String): Call<NewsSource>
}