package com.upb.certupb2023.mainscreen.fragments.home.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.upb.certupb2023.TemporalDb
import com.upb.certupb2023.data.repositories.StoresRepository
import com.upb.certupb2023.data.repositories.StoriesRepository
import com.upb.certupb2023.mainscreen.models.HomeListItem
import com.upb.certupb2023.mainscreen.models.StoryItem
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    init {
        println("INIT HomeViewModel")
    }

    val storiesRepository = StoriesRepository()
    val homeRepository = StoresRepository()

    val user = TemporalDb.observeUser()

    val storyList = MutableLiveData<List<StoryItem>>(listOf())

    val storesList = MutableLiveData<List<HomeListItem>>(listOf())

    fun getStoryList() {
        viewModelScope.launch {
            storiesRepository.getStoryList().zip(storiesRepository.getViewedStories()) { storyList, viewedStoryIds ->
                storyList.forEach { s ->
                    if (viewedStoryIds.contains(s.storyId)) {
                        s.viewed = true
                    }
                }
                return@zip storyList.sortedByDescending { !it.viewed }
            }.collect {
                storyList.value = it
                println(it.toString())
            }
        }
    }

    fun getStoresList() {
        viewModelScope.launch {
            homeRepository.getStoresList().collect {
                storesList.value = it
                println(it.toString())
            }
        }
    }
}