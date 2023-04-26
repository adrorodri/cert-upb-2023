package com.upb.certupb2023.mainscreen.models

data class StoryItem(val storyId: String,
                     val storeId: String,
                     val logoUrl: String,
                     val coverImageUrl: String,
                     var viewed: Boolean = false)