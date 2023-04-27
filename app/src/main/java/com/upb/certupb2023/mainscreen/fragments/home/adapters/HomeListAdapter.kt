package com.upb.certupb2023.mainscreen.fragments.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.upb.certupb2023.R
import com.upb.certupb2023.databinding.HomeListItemBinding
import com.upb.certupb2023.databinding.HomeListItemTagBinding
import com.upb.certupb2023.mainscreen.models.HomeListItem
import com.upb.certupb2023.mainscreen.models.Tag

class HomeListAdapter(var itemList: List<HomeListItem>, val onItemClickListener: (item: HomeListItem) -> Unit): RecyclerView.Adapter<HomeListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListViewHolder {
        val binding = HomeListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: HomeListViewHolder, position: Int) {
        holder.binding.homeListItem = itemList[position]
        holder.itemView.setOnClickListener { onItemClickListener(itemList[position]) }
    }
}

class HomeListViewHolder(val binding: HomeListItemBinding): RecyclerView.ViewHolder(binding.root)