package com.example.newsgenz.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsgenz.R
import com.example.newsgenz.databinding.FragmentTopNewsBinding
import com.example.newsgenz.model.ArticleDao
import com.example.newsgenz.model.NewsRepository
import com.example.newsgenz.model.retrofit.RetrofitProvider
import com.example.newsgenz.model.room.ArticleDatabase
import com.example.newsgenz.view.adapter.NewsAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TopNewsFragment : Fragment() {

    private lateinit var binding: FragmentTopNewsBinding
    private var adapter: NewsAdapter? = null
    private lateinit var articleDao: ArticleDao
    private lateinit var newsRepository: NewsRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_top_news, container, false)
        articleDao = ArticleDatabase.getDatabaseInstance(requireContext()).articleDao()
        newsRepository = NewsRepository(articleDao)
        fetchNews(binding.recyclerView)
        val rc = binding.recyclerView
        rc.layoutManager = LinearLayoutManager(requireContext())
        searchNews()
        return binding.root
    }

    private fun searchNews() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                adapter?.submitSearchText(p0)
                return true
            }

        })
    }

    private fun fetchNews(recyclerView: RecyclerView) {
        CoroutineScope(Dispatchers.IO).launch {

            try {
                val response = RetrofitProvider.getNewsApiService().getEveryNews()
                if (response.isSuccessful) {
                    val items = response.body()?.articles?.filter { it.title != "[Removed]" }
                    Log.d("checkkk", "fetchNews: $items")
                    withContext(Dispatchers.Main) {
                        adapter = items?.let {
                            NewsAdapter(it) { article ->
                                bookmarkArticle(article)
                            }
                        }
                        recyclerView.adapter = adapter
                    }
                } else {
                    Log.e("checkkk", "Error response not successful")
                }
            } catch (e: Exception) {
                Log.e("checkkk", "Error fetching news", e)
            }
        }
    }

    private fun bookmarkArticle(article: Article) {
        CoroutineScope(Dispatchers.IO).launch {
            newsRepository.saveArticle(article)
        }
        Toast.makeText(requireContext(), "Article Saved", Toast.LENGTH_SHORT).show()
    }
    companion object
}
