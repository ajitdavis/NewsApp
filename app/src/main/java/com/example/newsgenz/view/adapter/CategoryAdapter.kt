package com.example.newsgenz.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsgenz.R
import com.example.newsgenz.model.CategoryItems
import com.example.newsgenz.model.CommonDataClass

class CategoryAdapter(private val item: List<CategoryItems>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var isShowingAll = false

    override fun getItemViewType(position: Int): Int {
        return when(item[position]){
            is CategoryItems.ListItems -> VIEW_TYPE_LIST_ITEMS
            is CategoryItems.NewsCategory -> VIEW_TYPE_CATEGORIES
            is CategoryItems.CorouselItems -> VIEW_TYPE_COROUSEL_ITEMS
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
//            VIEW_TYPE_LIST_ITEMS -> {
//                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
//                ListViewHolder(view)
//            }
            VIEW_TYPE_COROUSEL_ITEMS -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_corousal,parent,false)
                CorouselViewHolder(view)
            }

//            VIEW_TYPE_CATEGORIES -> {
//                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category,parent,false)
//                CategoriesViewHolder(view)
//            }
            else -> throw IllegalArgumentException("error")
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = item[position]
        when(holder) {
//            is ListViewHolder -> {
//                if(currentItem is CategoryItems.ListItems)
//                    holder.bind(currentItem.list[position])
//            }
//            is CategoriesViewHolder -> {
//                if(currentItem is CategoryItems.NewsCategory)
//                    holder.bind(currentItem)
//            }
            is CorouselViewHolder -> {
                if(currentItem is CategoryItems.CorouselItems)
                    holder.bind(currentItem)
            }
        }
    }

//    inner class ListViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
//        private var text2: TextView = itemView.findViewById(R.id.listTextView2)
//        private val text1: TextView = itemView.findViewById(R.id.listTextView1)
//        fun bind(dataItem: CommonDataClass){
//            text1.text = dataItem.text
//            text2.text = dataItem.desc
//        }
//    }

//    inner class CategoriesViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
//        private val recyclerView: RecyclerView = itemView.findViewById(R.id.recyclerViewCategories)
//        private val viewAllButton: TextView = itemView.findViewById(R.id.viewAllText)
//        fun bind(dataItem: CategoryItems.NewsCategory){
//            recyclerView.apply {
//                layoutManager = GridLayoutManager(itemView.context,2)
//                adapter = if(isShowingAll)CategoriesAdapter(dataItem.list) else CategoriesAdapter(dataItem.list.take(4))
//            }
//            viewAllButton.text = if (isShowingAll) "View less" else "View All"
//            viewAllButton.setOnClickListener{
//                toggleViewAll()
//            }
//        }
//    }

    inner class CorouselViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        private val recyclerView:RecyclerView = itemView.findViewById(R.id.corousalRecyclerView)
        fun bind(dataView: CategoryItems.CorouselItems){
            recyclerView.apply {
                layoutManager = LinearLayoutManager(itemView.context,LinearLayoutManager.HORIZONTAL,false)
                val cAdapter = CorouselAdapter(dataView.list)
                adapter = cAdapter
            }
        }

    }

    private fun toggleViewAll() {
        isShowingAll = !isShowingAll
        notifyDataSetChanged()
    }

    companion object {
        private const val VIEW_TYPE_CATEGORIES = 0
        private const val VIEW_TYPE_LIST_ITEMS = 1
        private const val VIEW_TYPE_COROUSEL_ITEMS = 2
    }
}