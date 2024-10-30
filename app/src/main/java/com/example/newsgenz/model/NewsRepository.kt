package com.example.newsgenz.model

class NewsRepository(val articleDao: ArticleDao) {

    suspend fun saveArticle(article: Article) {
        articleDao.insertArticle(article)
    }

    suspend fun getAllArticles():List<Article>{
        return articleDao.getAllArticles()
    }

    suspend fun deleteArticle(article: Article){
        articleDao.deleteArticle(article)
    }
}