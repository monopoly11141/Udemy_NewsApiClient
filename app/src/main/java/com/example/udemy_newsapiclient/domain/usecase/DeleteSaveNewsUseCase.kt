package com.example.udemy_newsapiclient.domain.usecase

import com.example.udemy_newsapiclient.data.model.Article
import com.example.udemy_newsapiclient.domain.repository.NewsRepository

class DeleteSaveNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article : Article) {
        newsRepository.deleteNews(article)
    }

}