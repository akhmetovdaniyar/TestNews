package com.example.testnews.presentation

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testnews.R
import com.example.testnews.data.model.Articles
import com.example.testnews.data.model.NewsSource
import kotlinx.android.synthetic.main.fragment_main.*
import androidx.browser.customtabs.CustomTabsIntent
import com.example.testnews.data.ViewInterface

class MainFragment : Fragment(), ViewInterface {
    private lateinit var presenter: Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = Presenter(this)
        presenter.getTopNews()
    }
    override fun showLoading() {
        progress_id_main.visibility = View.VISIBLE

    }

    override fun showTopNews(news: NewsSource) {
        progress_id_main.visibility = View.GONE
        getNews(news)
    }

    private fun getNews(newsSource: NewsSource){

        val adapter = NewsAdapter(newsSource, object : onNewsClickListener {
            override fun newsURLClicked(news: Articles) {
                Log.d("getNews Attached url ", news.url)
                val builder = CustomTabsIntent.Builder()
                val customTabsIntent = builder.build()
                //customTabsIntent.launchUrl(activity?.applicationContext, Uri.parse(news.url))
                context?.let { customTabsIntent.launchUrl(it, Uri.parse(news.url)) }
            }
        })

        rvList.layoutManager = LinearLayoutManager(activity?.applicationContext)
        rvList.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}