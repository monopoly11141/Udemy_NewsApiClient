package com.example.udemy_newsapiclient.data.repository.dataSoureImpl

import com.example.udemy_newsapiclient.data.db.ArticleDao
import com.example.udemy_newsapiclient.data.model.Article
import com.example.udemy_newsapiclient.data.repository.dataSource.NewsLocalDataSource

class NewsLocalDataSourceImpl(private val articleDao : ArticleDao) : NewsLocalDataSource {

    override suspend fun saveArticleToDB(article: Article) {
        articleDao.insert(article)
    }

}