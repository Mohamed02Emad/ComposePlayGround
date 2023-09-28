package com.mo.composeplayground.data.models

import com.androiddevs.mvvmnewsapp.data.models.Source
import java.io.Serializable

data class Article(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
) : Serializable
