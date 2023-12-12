package com.bankoti.firstday.Views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bankoti.firstday.Models.Article
import com.bankoti.firstday.R
import com.bumptech.glide.Glide

class NewsAdapter(private val newsList: List<Article>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = newsList[position]
        holder.itemView.apply {
            findViewById<TextView>(R.id.titleTextView).text = news.title
            findViewById<TextView>(R.id.descriptionTextView).text = news.description
            Glide.with(context).load(news.urlToImage).into( findViewById<ImageView>(R.id.newsImageView))

            setOnClickListener {
                // Handle item click (open the news article)
            }
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}