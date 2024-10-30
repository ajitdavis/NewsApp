package com.example.newsgenz.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsgenz.R
import com.example.newsgenz.databinding.FragmentCategoryBinding
import com.example.newsgenz.model.Category
import com.example.newsgenz.model.CategoryItems
import com.example.newsgenz.model.CommonDataClass
import com.example.newsgenz.view.adapter.CategoryAdapter


class CategoryFragment : Fragment() {
    private lateinit var binding :FragmentCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_category,container,false)
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        val modernList = getList()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = CategoryAdapter(modernList)
        }
    }

    private fun getList(): List<CategoryItems> {
        val carouselList = CategoryItems.CorouselItems(listOf("corouselList 1","corouselList 2","corouselList 3","corouselList 4","corouselList 5","corouselList 6"))
//        val image = context?.let { ContextCompat.getDrawable(it,R.drawable.games) }
//        val categoryList = CategoryItems.NewsCategory(listOf(
//            Category("Politics",image),
//            Category("Movies",image),
//            Category("Games",image),
//            Category("Business",image),
//            Category("Sports",image),
//            Category("International",image),
//            Category("Entertainment",image),
//            Category("LifeStyle",image),))
////        val initialCategoryList = categoryList.list.take(4)
//        val listList = CategoryItems.ListItems(listOf(CommonDataClass("CommonDataClass","CommonDataClass Text"),CommonDataClass("CommonDataClass 2","CommonDataClass Text 2"),CommonDataClass("CommonDataClass 3","CommonDataClass Text3")))
        return listOf(carouselList,carouselList,carouselList)

    }

}