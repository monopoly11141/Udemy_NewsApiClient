package com.example.udemy_newsapiclient.presentation.di

import com.example.udemy_newsapiclient.presentation.adapter.NewsAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AdapterModule {

    @Singleton
    @Provides
    fun providesNewsAdapter() : NewsAdapter {
        return NewsAdapter()
    }

}