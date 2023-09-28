package com.mo.composeplayground.data.repositories

import android.content.Context
import com.androiddevs.mvvmnewsapp.data.models.NewsResponse
import com.mo.composeplayground.data.api.NewsAPI
import retrofit2.Response

class NewsRepository(val api: NewsAPI, val context: Context) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int = 1): Response<NewsResponse> {
        return api.getHeadLineNews(
            countryCode = countryCode,
            pageNumber = pageNumber
        )
    }

    suspend fun searchForNews(query: String, pageNumber: Int = 1): Response<NewsResponse> {
        return api.searchForNews(searchQuery = query, pageNumber = pageNumber)
    }

}