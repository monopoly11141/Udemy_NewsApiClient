package com.example.udemy_newsapiclient.presentation.di

import com.example.udemy_newsapiclient.data.db.ArticleDao
import com.example.udemy_newsapiclient.data.repository.dataSource.NewsLocalDataSource
import com.example.udemy_newsapiclient.data.repository.dataSoureImpl.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideLocalDataSource(articleDao: ArticleDao): NewsLocalDataSource {
        return NewsLocalDataSourceImpl(articleDao)
    }

}