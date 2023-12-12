package com.bankoti.firstday.Models

data class NewsResponse(  val articles: List<Article>,
                          val status: String,
                          val totalResults: Int)

data class Article( val title: String,
                    val description: String?,
                    val url: String,
                    val urlToImage: String?)


