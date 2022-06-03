package com.example.testnews.data

import com.example.testnews.data.model.NewsSource

interface ViewInterface {
    fun showLoading()
    fun showTopNews(news: NewsSource)
}