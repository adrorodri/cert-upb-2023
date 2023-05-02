package com.upb.certupb2023.mainscreen.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class HomeListItem(
    @PrimaryKey val id: String,
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