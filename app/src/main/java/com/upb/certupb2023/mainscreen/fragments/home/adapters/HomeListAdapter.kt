package com.upb.certupb2023.mainscreen.fragments.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.upb.certupb2023.R
import com.upb.certupb2023.mainscreen.fragments.home.models.HomeListItem

class HomeListAdapter(val itemList: List<HomeListItem>, val onItemClickListener: (item: HomeListItem) -> Unit): RecyclerView.Adapter<HomeListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.home_list_item, parent, false)
        return HomeListViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: HomeListViewHolder, position: Int) {
        holder.tvTitle.text = itemList[position].title
        holder.ivBackground.setImageResource(itemList[position].image)
        holder.itemView.setOnClickListener { onItemClickListener(itemList[position]) }
    }
}

class HomeListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val tvTitle: TextView = itemView.findViewById(R.id.tvItemTitle)
    val ivBackground: ImageView = itemView.findViewById(R.id.ivItemBackground)
}