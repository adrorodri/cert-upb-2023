package com.upb.certupb2023.data.repositories

import android.content.Context
import android.net.ConnectivityManager
import androidx.core.content.ContextCompat.getSystemService
import com.upb.certupb2023.data.api.ApiClient
import com.upb.certupb2023.data.persistency.StoresPersistency
import com.upb.certupb2023.mainscreen.models.HomeListItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow


class StoresRepository {
    val apiClient = ApiClient()
    val persistency = StoresPersistency()

    fun getStoresList(context: Context): Flow<List<HomeListItem>> {
        return flow {
            emit(persistency.getStores(context) ?: listOf())
            if (isNetworkAvailable(context)) {
                val serverResponse = apiClient.getStoresList().first()
                persistency.saveStores(context, serverResponse)
                emit(serverResponse)
            }
        }
    }


    private fun isNetworkAvailable(context: Context): Boolean {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return manager!!.activeNetworkInfo?.isConnected ?: false
    }
}