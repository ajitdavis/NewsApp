package com.example.newsgenz.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article: Article)

    @Query("SELECT * from articles")
    suspend fun getAllArticles(): List<Article>

//    @Query("SELECT * FROM articles WHERE isLiked = 1")
//    suspend fun getLikedArticles(): List<Article>
//
//    @Query("UPDATE articles SET isLiked = :isLiked WHERE id = :articleId")
//    suspend fun updateArticleLikeStatus(articleId: Long, isLiked: Boolean)

    @Delete
    suspend fun deleteArticle(article: Article)

//    @Entity(tableName = "articles")
//    data class Article(
//        @PrimaryKey(autoGenerate = true) val id:Long = 0,
//        val author: String? = null,
//        val content: String? = null,
//        val description: String? = null,
//        val publishedAt: String,
//        val source: Source? = null,
//        val title: String,
//        val url: String,
//        val urlToImage: String? = null
//    ): Serializable

}