package com.upb.certupb2023.data.repositories

import com.upb.certupb2023.data.api.ApiClient
import com.upb.certupb2023.data.persistency.StoresPersistency
import com.upb.certupb2023.mainscreen.models.HomeListItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoresRepository {
    val apiClient = ApiClient()
    val persistency = StoresPersistency()

    fun getStoresList(): Flow<List<HomeListItem>> {
        return apiClient.getStoresList().map {
            persistency.saveStores(it)
            it
        }
    }
}