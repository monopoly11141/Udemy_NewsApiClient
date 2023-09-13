package com.example.udemy_newsapiclient.presentation.di

import com.example.udemy_newsapiclient.data.NewsRepositoryImpl
import com.example.udemy_newsapiclient.data.repository.dataSource.NewsLocalDataSource
import com.example.udemy_newsapiclient.data.repository.dataSource.NewsRemoteDataSource
import com.example.udemy_newsapiclient.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource,
        newsLocalDataSource: NewsLocalDataSource
    ) : NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource, newsLocalDataSource)
    }

}