package com.example.udemy_newsapiclient.domain.repository

import com.example.udemy_newsapiclient.data.model.APIResponse
import com.example.udemy_newsapiclient.data.model.Article
import com.example.udemy_newsapiclient.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getNewsHeadlines(country : String, page : Int) : Resource<APIResponse>

    suspend fun getSearchedNews(searchQuery : String) : Resource<APIResponse>

    suspend fun saveNews(article : Article)
    suspend fun deleteNews(article : Article)

    fun getSavedNews() : Flow<List<Article>>

}