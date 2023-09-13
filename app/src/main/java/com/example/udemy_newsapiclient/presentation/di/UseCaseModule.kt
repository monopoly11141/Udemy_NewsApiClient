package com.example.udemy_newsapiclient.presentation.di

import com.example.udemy_newsapiclient.domain.repository.NewsRepository
import com.example.udemy_newsapiclient.domain.usecase.GetNewsHeadlinesUseCase
import com.example.udemy_newsapiclient.domain.usecase.GetSearchedNewsUseCase
import com.example.udemy_newsapiclient.domain.usecase.SaveNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideNewsHeadlineUseCase(newsRepository: NewsRepository) : GetNewsHeadlinesUseCase {
        return GetNewsHeadlinesUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideGetSearchedUseCase(newsRepository: NewsRepository) : GetSearchedNewsUseCase {
        return GetSearchedNewsUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideSaveNewsUseCase(newsRepository: NewsRepository) : SaveNewsUseCase {
        return SaveNewsUseCase(newsRepository)
    }

}