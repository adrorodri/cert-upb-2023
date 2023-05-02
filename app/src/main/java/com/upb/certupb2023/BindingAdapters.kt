package com.upb.certupb2023

import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.upb.certupb2023.databinding.HomeListItemTagBinding
import com.upb.certupb2023.mainscreen.models.HomeListItem
import com.upb.certupb2023.mainscreen.models.Tag

class BindingAdapters {
    companion object {
        @JvmStatic @BindingAdapter("srcUrl")
        fun loadUrlImageView(imageView: ImageView, url: String) {
            Glide.with(imageView).load(url).into(imageView)
        }

        @JvmStatic @BindingAdapter(value = ["srcUrl", "circleCrop"])
        fun loadUrlImageViewCircleCrop(imageView: ImageView, url: String, circleCrop: Boolean = false) {
            if (circleCrop) {
                Glide.with(imageView).load(url).circleCrop().into(imageView)
            } else {
                Glide.with(imageView).load(url).into(imageView)
            }
        }

        @JvmStatic @BindingAdapter("addTagViewsFor")
        fun addTagsToView(layout: LinearLayout, homeListItem: HomeListItem) {
            layout.removeAllViews()
            homeListItem.tags.forEach { tag ->
                val binding = HomeListItemTagBinding.inflate(LayoutInflater.from(layout.context), layout, false)
                binding.ivTagIcon.setImageResource(when(tag) {
                    Tag.STORE -> R.drawable.ic_store
                    Tag.PETS -> R.drawable.ic_person
                    Tag.JEWELERY -> R.drawable.ic_phone
                })
                layout.addView(binding.root)
            }
        }
    }
}