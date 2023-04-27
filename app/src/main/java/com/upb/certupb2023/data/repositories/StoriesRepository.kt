package com.upb.certupb2023.data.repositories

import com.upb.certupb2023.data.api.ApiClient
import com.upb.certupb2023.mainscreen.models.StoryItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class StoriesRepository {
    fun getStoryList(): Flow<List<StoryItem>> {
        return flowOf(listOf(
            StoryItem("1", "123", "https://media.istockphoto.com/id/908909714/pt/vetorial/vector-group-of-pets-dog-cat-parrot-on-white-background-beautiful-pet-symbol-pet-icon-easy.jpg?s=612x612&w=0&k=20&c=MobzGBzk0u9-ghIwcQi1ujJtapkFf0gIrqFrjoWRTL0=","kasjdkjaskdj"),
            StoryItem("2", "234", "https://www.logodesign.net/images/home-industry/jewelry-logo-02.jpg", "kasjdkjaskdj"),
            StoryItem("3", "345", "https://media.istockphoto.com/id/874045548/vector/shirt-icon.jpg?s=612x612&w=0&k=20&c=ZJCxsCczemu1XhYRMDCByrYdwotBESuFdC5tkGf1a6g=", "kasjdkjaskdj")
        ))
    }

    fun getViewedStories(): Flow<List<String>> {
        return flowOf(listOf("1"))
    }
}