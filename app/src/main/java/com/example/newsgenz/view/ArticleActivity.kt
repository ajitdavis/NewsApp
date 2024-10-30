package com.example.newsgenz.view

import android.os.Bundle
import android.util.Log
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.newsgenz.R
import com.example.newsgenz.databinding.ActivityArticleBinding
import com.example.newsgenz.model.ArticleDao
import com.example.newsgenz.model.NewsRepository
import com.example.newsgenz.model.room.ArticleDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArticleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArticleBinding
    private lateinit var articleDao: ArticleDao
    private lateinit var repository: NewsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this,R.layout.activity_article)
        articleDao = ArticleDatabase.getDatabaseInstance(this).articleDao()
        repository = NewsRepository(articleDao)

        val item = intent.getSerializableExtra("article") as? Article
        Log.d("checkkk", "onCreate: ${item?.url}")

        if(item == null)
        {
            Log.d("checkkk", "onCreate: item is null ")
            finish()
        }
        val webView = binding.webView.apply {
            settings.javaScriptEnabled = true
            webViewClient  = WebViewClient()
        }

        binding.likeButton.setOnClickListener{
            saveArticle(item)
        }

        item?.let { webView.loadUrl(it.url) }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun saveArticle(item: Article?) {
        CoroutineScope(Dispatchers.IO).launch {
            item?.let { repository.saveArticle(it) }
        }
        Toast.makeText(this,"Article Saved",Toast.LENGTH_SHORT).show()
    }
}