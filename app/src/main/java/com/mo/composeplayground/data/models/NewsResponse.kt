package com.androiddevs.mvvmnewsapp.data.models

import androidx.annotation.Keep
import com.mo.composeplayground.data.models.Article

@Keep
data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)