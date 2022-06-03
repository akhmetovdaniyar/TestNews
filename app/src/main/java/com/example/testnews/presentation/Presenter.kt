package com.example.testnews.presentation

import android.util.Log
import com.example.testnews.data.model.Const
import com.example.testnews.data.retrofit.ApiService
import com.example.testnews.data.retrofit.RetrofitInstance
import com.example.testnews.data.PresenterInterface
import com.example.testnews.data.ViewInterface
import com.example.testnews.data.model.NewsSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter(_view: ViewInterface): PresenterInterface {

    private var view: ViewInterface? = _view
    private lateinit var model: NewsSource

    override fun getTopNews() {
        makeRetrofitCall()
    }

    private fun makeRetrofitCall(){
        val newsRequest = RetrofitInstance().retrofitInstances.create(ApiService::class.java)
        val call = newsRequest.getNews(Const.COUNTRY, Const.API_KEY)
        call.enqueue(object : Callback<NewsSource> {
            override fun onFailure(call: Call<NewsSource>, t: Throwable) {
                Log.d("News Error ", ""+t.message)
            }
            override fun onResponse(call: Call<NewsSource>, response: Response<NewsSource>) {
                val res = response.body()
                Log.i("Title ", ""+res!!.articles[1].title)
                view?.showTopNews(res!!)
            }

        })
    }

    override fun onDestroy() {
        view = null
    }
}