package com.upb.certupb2023.data.repositories

import android.content.Context
import android.net.ConnectivityManager
import com.upb.certupb2023.data.api.ApiClient
import com.upb.certupb2023.data.persistency.RoomPersistency
import com.upb.certupb2023.mainscreen.models.HomeListItem
import kotlinx.coroutines.flow.*


class StoresRepository {
    val apiClient = ApiClient()

    fun getStoresList(context: Context): Flow<List<HomeListItem>> {
        val roomPersistency = RoomPersistency.getInstance(context)
        return roomPersistency.StoresDao().getStores()
    }

    fun searchStoreList(context: Context, searchStr: String): Flow<List<HomeListItem>> {
        val roomPersistency = RoomPersistency.getInstance(context)
        return roomPersistency.StoresDao().searchStores(searchStr)
    }

    suspend fun updateStoreList(context: Context) {
        val roomPersistency = RoomPersistency.getInstance(context)
        if (isNetworkAvailable(context)) {
            val newList = apiClient.getStoresList().first()
            roomPersistency.StoresDao().saveStores(newList)
        }
    }

    private fun isNetworkAvailable(context: Context): Boolean {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return manager!!.activeNetworkInfo?.isConnected ?: false
    }
}