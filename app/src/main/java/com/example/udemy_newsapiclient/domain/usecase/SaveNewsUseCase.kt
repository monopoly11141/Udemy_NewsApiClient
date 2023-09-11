package com.example.udemy_newsapiclient.domain.usecase

import com.example.udemy_newsapiclient.data.model.Article
import com.example.udemy_newsapiclient.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article : Article) {
        newsRepository.saveNews(article)
    }

}