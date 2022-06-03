package com.example.testnews.data.retrofit

import com.example.testnews.data.model.Const
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    val retrofitInstances: Retrofit
        get() {
            val loggingInterceptor = HttpLoggingInterceptor()
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            return Retrofit.Builder()
                .baseUrl(Const.BASE_URL_NEWS)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        }
}