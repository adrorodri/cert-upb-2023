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

class HomeListAdapter(val itemList: List<HomeListItem>, val onItemClickListener: (item: HomeListItem) -> Unit): RecyclerView.Adapter<HomeListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListViewHolder {
        val binding = HomeListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: HomeListViewHolder, position: Int) {
        holder.binding.tvItemTitle.text = itemList[position].title
        Glide.with(holder.itemView).load(itemList[position].coverImageUrl).into(holder.binding.ivItemBackground)
        Glide.with(holder.itemView).load(itemList[position].logoUrl).circleCrop().into(holder.binding.ivLogo)

        itemList[position].tags.forEach { tag ->
            val binding = HomeListItemTagBinding.inflate(LayoutInflater.from(holder.itemView.context), holder.binding.lyTags, false)
            binding.ivTagIcon.setImageResource(when(tag) {
                Tag.STORE -> R.drawable.ic_store
                Tag.PETS -> R.drawable.ic_person
                Tag.JEWELERY -> R.drawable.ic_phone
            })
            holder.binding.lyTags.addView(binding.root)
        }

        holder.itemView.setOnClickListener { onItemClickListener(itemList[position]) }
    }
}

class HomeListViewHolder(val binding: HomeListItemBinding): RecyclerView.ViewHolder(binding.root)