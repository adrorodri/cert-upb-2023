package com.upb.certupb2023.mainscreen.fragments.home.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.upb.certupb2023.TemporalDb
import com.upb.certupb2023.data.repositories.StoresRepository
import com.upb.certupb2023.data.repositories.StoriesRepository
import com.upb.certupb2023.data.repositories.UsersRepository
import com.upb.certupb2023.mainscreen.models.HomeListItem
import com.upb.certupb2023.mainscreen.models.StoryItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch

class HomeViewModel(val storiesRepository: StoriesRepository,
                    val storesRepository: StoresRepository,
                    val usersRepository: UsersRepository) : ViewModel() {
    init {
        println("INIT HomeViewModel")
    }

    val user = TemporalDb.observeUser()

    val storyList = MutableLiveData<List<StoryItem>>(listOf())

    val storesList = MutableLiveData<List<HomeListItem>>(listOf())

    var getAllJob: Job? = null

    fun getStoryList() {
        viewModelScope.launch {
            storiesRepository.getStoryList()
                .zip(storiesRepository.getViewedStories()) { storyList, viewedStoryIds ->
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

    fun getStoresList(onError: () -> Unit) {
        getAllJob = viewModelScope.launch {
            storesRepository.getStoresList()
                .flowOn(Dispatchers.IO)
                .catch {
                    it.printStackTrace()
                    onError()
                }
                .collect {
                    storesList.value = it
                    println(it.toString())
                }
        }
        viewModelScope.launch(Dispatchers.IO) {
            storesRepository.updateStoreList()
        }
    }

    fun searchStoreList(searchStr: String) {
        getAllJob?.cancel()
        viewModelScope.launch {
            storesRepository.searchStoreList(searchStr)
                .flowOn(Dispatchers.IO)
                .collect {
                    storesList.value = it
                    println(it.toString())
                }
        }
    }

    suspend fun isUserLoggedIn(): Boolean {
        return usersRepository.isLoggedIn()
    }

    fun logout(): Flow<Unit> {
        return usersRepository.logout()
    }
}