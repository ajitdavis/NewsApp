package com.example.newsgenz.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.newsgenz.model.Article
import com.example.newsgenz.model.ArticleDao
import kotlin.jvm.Volatile

@Database(entities = [Article::class], version = 1) // Make sure your version is incremented
@TypeConverters(Converter::class)
abstract class ArticleDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao

    companion object {
        @Volatile
        private var INSTANCE: ArticleDatabase? = null

        fun getDatabaseInstance(context: Context): ArticleDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ArticleDatabase::class.java,
                    "article_database"
                )
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}