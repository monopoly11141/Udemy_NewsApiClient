package com.example.udemy_newsapiclient.data.repository.dataSoureImpl

import com.example.udemy_newsapiclient.data.api.NewsAPIService
import com.example.udemy_newsapiclient.data.model.APIResponse
import com.example.udemy_newsapiclient.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService : NewsAPIService,
    private val country : String,
    private val page : Int
) : NewsRemoteDataSource {

    override suspend fun getTopHeadlines(): Response<APIResponse> {
        return newsAPIService.getTopHeadlines(country, page)
    }

}