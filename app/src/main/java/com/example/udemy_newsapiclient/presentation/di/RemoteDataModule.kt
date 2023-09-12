package com.example.udemy_newsapiclient.presentation.di

import com.example.udemy_newsapiclient.data.api.NewsAPIService
import com.example.udemy_newsapiclient.data.repository.dataSource.NewsRemoteDataSource
import com.example.udemy_newsapiclient.data.repository.dataSoureImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module()
class RemoteDataModule {

    @Singleton
    @Provides
    fun providesNewsRemoteDataSource(newsAPIService: NewsAPIService) : NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsAPIService)
    }

}