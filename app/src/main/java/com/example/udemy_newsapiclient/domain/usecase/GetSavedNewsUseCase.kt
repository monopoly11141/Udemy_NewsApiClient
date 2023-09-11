package com.example.udemy_newsapiclient.domain.usecase

import com.example.udemy_newsapiclient.data.model.Article
import com.example.udemy_newsapiclient.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {

    fun execute(): Flow<List<Article>> {
        return newsRepository.getSavedNews()
    }

}