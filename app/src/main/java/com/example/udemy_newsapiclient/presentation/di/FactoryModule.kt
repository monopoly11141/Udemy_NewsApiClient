package com.example.udemy_newsapiclient.presentation.di

import android.app.Application
import com.example.udemy_newsapiclient.domain.usecase.GetNewsHeadlinesUseCase
import com.example.udemy_newsapiclient.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class FactoryModule {

    @Singleton
    @Provides
    fun providesNewsViewModelFactory(
        application: Application,
        getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(application, getNewsHeadlinesUseCase)
    }

}