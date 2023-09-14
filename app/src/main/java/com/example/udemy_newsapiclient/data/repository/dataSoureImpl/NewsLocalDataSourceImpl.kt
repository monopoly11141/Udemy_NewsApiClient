package com.example.udemy_newsapiclient.data.repository.dataSoureImpl

import com.example.udemy_newsapiclient.data.db.ArticleDao
import com.example.udemy_newsapiclient.data.model.Article
import com.example.udemy_newsapiclient.data.repository.dataSource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow

class NewsLocalDataSourceImpl(private val articleDao : ArticleDao) : NewsLocalDataSource {

    override suspend fun saveArticleToDB(article: Article) {
        articleDao.insert(article)
    }

    override fun getSavedArticles(): Flow<List<Article>> {
        return articleDao.getAllArticles()
    }

    override suspend fun deleteArticlesFromDB(article: Article) {
        return articleDao.deleteArticle(article)
    }

}