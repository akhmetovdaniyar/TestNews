package com.example.testnews.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testnews.R
import com.example.testnews.data.model.Articles
import com.example.testnews.data.model.NewsSource
import kotlinx.android.synthetic.main.news_adapter.view.*

class NewsAdapter(private val newSource: NewsSource, private val listener: onNewsClickListener)
    : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.news_adapter, parent, false))
    }
    override fun getItemCount(): Int {
        return newSource.articles.size
    }
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.tvAuthor.text = newSource.articles[position].author
        holder.tvTitle.text = newSource.articles[position].title
        holder.tvDescription.text = newSource.articles[position].description
        holder.bind(newSource.articles[position], listener)
    }
    class NewsViewHolder (view: View) :RecyclerView.ViewHolder(view){
        val tvTitle = view.tv_title
        val tvAuthor = view.tv_author
        val tvDescription = view.tv_description
        fun bind(url: Articles, listener: onNewsClickListener){
            itemView.setOnClickListener {
                listener.newsURLClicked(url)
            }
        }
    }
}
interface onNewsClickListener{
    fun newsURLClicked(news: Articles)
}