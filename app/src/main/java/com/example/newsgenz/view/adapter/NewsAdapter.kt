package com.example.newsgenz.view.adapter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsgenz.R
import com.example.newsgenz.model.Article
import com.example.newsgenz.view.ArticleActivity

class NewsAdapter(private val itemList: List<Article>, private val bookmarkClick:(Article) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var newList = itemList.toMutableList()

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewImage: ImageView = itemView.findViewById(R.id.itemImageView)
        val textViewTitle: TextView = itemView.findViewById(R.id.itemTitle)
        val bookMark: ImageView = itemView.findViewById(R.id.itemBookmark)

        fun bind(item: Article) {
            Glide.with(itemView.context)
                .load(item.urlToImage)
                .error(R.drawable.ic_launcher_foreground)
                .into(textViewImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = newList[position]
        holder.textViewTitle.text = item.title
        holder.bind(item)
        Log.d("checkkk", "onBindViewHolder: $item")

        holder.bookMark.setOnClickListener{
            bookmarkClick(item)
        }

        holder.itemView.setOnClickListener {

            val bundle = Bundle().apply {
                putSerializable("article", item)
            }

//            onItemClickListener?.let {
//                it(item)
//            }
            val intent = Intent(holder.itemView.context, ArticleActivity::class.java).apply {
                putExtra("article", item)
            }
            holder.itemView.context.startActivity(intent)
        }

    }


//    private var onItemClickListener:((Article)->Unit)?=null
//
//    fun onItemClickListener(listener:(Article) -> Unit) {
//        onItemClickListener = listener
//    }

    override fun getItemCount(): Int {
        return newList.size
    }

    fun submitSearchText(text: String?) {
        newList.clear()
        if (text.isNullOrEmpty()) {
            newList.addAll(itemList)
        } else {
            for (news in itemList) {
                if (news.title.contains(text, true))
                    newList.add(news)
            }
        }
        notifyDataSetChanged()
    }
}