package com.example.udemy_newsapiclient.domain.usecase

import com.example.udemy_newsapiclient.data.model.APIResponse
import com.example.udemy_newsapiclient.data.util.Resource
import com.example.udemy_newsapiclient.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country : String, page : Int) : Resource<APIResponse> {
        return newsRepository.getNewsHeadlines(country, page)
    }

}