package com.upb.certupb2023.mainscreen.fragments.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.upb.certupb2023.R
import com.upb.certupb2023.databinding.StoryItemBinding
import com.upb.certupb2023.mainscreen.models.StoryItem

class StoryAdapter(var storyItemList: List<StoryItem>): RecyclerView.Adapter<StoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        return StoryViewHolder(StoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return storyItemList.size
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        Glide.with(holder.itemView).load(storyItemList[position].logoUrl).circleCrop().into(holder.binding.ivStoryLogo)
        if (storyItemList[position].viewed) {
            holder.binding.ivStoryViewStatus.setImageResource(R.drawable.shape_circle_border_gray)
        } else {
            holder.binding.ivStoryViewStatus.setImageResource(R.drawable.shape_circle_border_colored)
        }
    }
}

class StoryViewHolder(val binding: StoryItemBinding): RecyclerView.ViewHolder(binding.root)