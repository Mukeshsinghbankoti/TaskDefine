package com.bankoti.firstday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bankoti.firstday.Models.Article
import com.bankoti.firstday.Models.NewsResponse
import com.bankoti.firstday.Networking.RetrofitInstance
import com.bankoti.firstday.Views.NewsAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsActivity : AppCompatActivity() {
    private val apiKey = "605687327ed54114b02249e8e9414766"
    private val country = "us"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val call = RetrofitInstance.api.getTopHeadlines(country, apiKey)

        call.enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    val newsList = response.body()?.articles ?: emptyList()
                    Log.e("Respons",newsList.toString())
                    showNews(newsList)
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                // Handle failure (e.g., show an error message)
            }
        })


    }
    private fun showNews(newsList: List<Article>) {
        val layoutManager = LinearLayoutManager(this)
        val   recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        val adapter = NewsAdapter(newsList)
        recyclerView.adapter = adapter
    }
}