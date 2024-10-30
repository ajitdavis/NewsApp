package com.example.newsgenz.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsgenz.R

class CorouselAdapter(val list: List<String>) : RecyclerView.Adapter<CorouselAdapter.CorousalViewHolder>() {

    inner class CorousalViewHolder(item: View): RecyclerView.ViewHolder(item){
        val textt: TextView = item.findViewById(R.id.inside_text)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CorousalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_inside_corousal,parent,false)
        return CorousalViewHolder(view)
    }

    override fun onBindViewHolder(holder: CorousalViewHolder, position: Int) {
        val curItem = list[position]

        holder.textt.text = curItem
    }

    override fun getItemCount(): Int {
        return list.size
    }

}
