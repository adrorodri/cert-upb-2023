package com.upb.certupb2023.data.repositories

import android.content.Context
import android.net.ConnectivityManager
import com.upb.certupb2023.data.api.ApiClient
import com.upb.certupb2023.data.persistency.RoomPersistency
import com.upb.certupb2023.mainscreen.models.HomeListItem
import kotlinx.coroutines.flow.*


class StoresRepository(val context: Context, val apiClient: ApiClient, val roomPersistency: RoomPersistency) {

    fun getStoresList(): Flow<List<HomeListItem>> {
        return roomPersistency.db.StoresDao().getStores()
    }

    fun searchStoreList(searchStr: String): Flow<List<HomeListItem>> {
        return roomPersistency.db.StoresDao().searchStores(searchStr)
    }

    suspend fun updateStoreList() {
        if (isNetworkAvailable(context)) {
            val newList = apiClient.getStoresList().first()
            roomPersistency.db.StoresDao().saveStores(newList)
        }
    }

    private fun isNetworkAvailable(context: Context): Boolean {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return manager!!.activeNetworkInfo?.isConnected ?: false
    }
}