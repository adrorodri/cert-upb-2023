package com.upb.certupb2023.mainscreen.fragments.home.models

data class HomeListItem(
    val title: String,
    val coverImageUrl: String,
    val logoUrl: String,
    val tags: List<Tag>
)

enum class Tag {
    STORE,
    PETS,
    JEWELERY
}