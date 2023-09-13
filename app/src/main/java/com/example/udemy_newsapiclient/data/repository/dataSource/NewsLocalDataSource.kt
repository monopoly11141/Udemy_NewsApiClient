package com.example.udemy_newsapiclient.data.repository.dataSource

import com.example.udemy_newsapiclient.data.model.Article

interface NewsLocalDataSource {

    suspend fun saveArticleToDB(article: Article)
}