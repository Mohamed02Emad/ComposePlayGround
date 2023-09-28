package com.androiddevs.mvvmnewsapp.di

import android.content.Context
import com.mo.composeplayground.data.repositories.NewsRepository
import com.mo.composeplayground.data.api.NewsAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Singleton
    @Provides
    fun provideNewsRepository(
        api: NewsAPI,
        @ApplicationContext context: Context
    ): NewsRepository = NewsRepository(api,context)


}