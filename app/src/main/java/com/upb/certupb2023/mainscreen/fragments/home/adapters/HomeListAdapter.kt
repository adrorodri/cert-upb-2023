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
import com.upb.certupb2023.mainscreen.fragments.home.models.HomeListItem
import com.upb.certupb2023.mainscreen.fragments.home.models.Tag

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
        Glide.with(holder.itemView).load(itemList[position].logoUrl).circleCrop().into(holder.ivLogo)

        itemList[position].tags.forEach { tag ->
            val view = LayoutInflater.from(holder.itemView.context).inflate(R.layout.home_list_item_tag, holder.lyTags, false)
            view.findViewById<ImageView>(R.id.ivTagIcon).setImageResource(when(tag) {
                Tag.STORE -> R.drawable.ic_store
                Tag.PETS -> R.drawable.ic_person
                Tag.JEWELERY -> R.drawable.ic_phone
            })
            holder.lyTags.addView(view)
        }

        holder.itemView.setOnClickListener { onItemClickListener(itemList[position]) }
    }
}

class HomeListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val tvTitle: TextView = itemView.findViewById(R.id.tvItemTitle)
    val ivBackground: ImageView = itemView.findViewById(R.id.ivItemBackground)
    val lyTags: LinearLayout = itemView.findViewById(R.id.lyTags)
    val ivLogo: ImageView = itemView.findViewById(R.id.ivLogo)
}