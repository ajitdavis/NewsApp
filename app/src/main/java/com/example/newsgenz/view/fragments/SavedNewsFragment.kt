package com.example.newsgenz.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsgenz.R
import com.example.newsgenz.databinding.FragmentSavedNewsBinding
import com.example.newsgenz.model.ArticleDao
import com.example.newsgenz.model.NewsRepository
import com.example.newsgenz.model.room.ArticleDatabase
import com.example.newsgenz.view.adapter.NewsAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SavedNewsFragment : Fragment() {

    private lateinit var binding: FragmentSavedNewsBinding
    private lateinit var articleDao: ArticleDao
    private lateinit var newsRepository: NewsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        articleDao = ArticleDatabase.getDatabaseInstance(requireContext()).articleDao()
        newsRepository = NewsRepository(articleDao)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_saved_news,container,false)
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {

        CoroutineScope(Dispatchers.IO).launch {
            val articles = newsRepository.getAllArticles()
            Log.d("checkkk", "Saved Fragment setupRecyclerView size: ${articles.size}")
            binding.recyclerView.apply {
                withContext(Dispatchers.Main){
                    adapter = NewsAdapter(articles){

                    }
                    layoutManager =  LinearLayoutManager(requireContext())

                }
            }
        }
    }
}