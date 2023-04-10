package com.upb.certupb2023.mainscreen.fragments.home.models

import androidx.annotation.DrawableRes

data class HomeListItem(val title: String, @DrawableRes val image: Int, val logoUrl: String, val tags: List<Tag>)

enum class Tag {
    STORE,
    PETS,
    JEWELERY
}