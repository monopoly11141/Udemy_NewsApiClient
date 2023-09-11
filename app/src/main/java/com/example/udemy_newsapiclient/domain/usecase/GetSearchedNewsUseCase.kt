package com.example.udemy_newsapiclient.domain.usecase

import com.example.udemy_newsapiclient.data.model.APIResponse
import com.example.udemy_newsapiclient.data.util.Resource
import com.example.udemy_newsapiclient.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(searchQuery : String) : Resource<APIResponse> {
        return newsRepository.getSearchedNews(searchQuery)
    }

}