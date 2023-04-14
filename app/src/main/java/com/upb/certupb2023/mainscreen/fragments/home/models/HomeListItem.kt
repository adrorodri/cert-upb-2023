package com.upb.certupb2023.mainscreen.fragments.home.models

import java.io.Serializable

data class HomeListItem(
    val title: String,
    val coverImageUrl: String,
    val logoUrl: String,
    val tags: List<Tag>
): Serializable //Requerido Serializable para usar SafeArgs

enum class Tag {
    STORE,
    PETS,
    JEWELERY
}