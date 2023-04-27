package com.upb.certupb2023.data.persistency

import com.upb.certupb2023.mainscreen.models.HomeListItem

class StoresPersistency {
    var stores: List<HomeListItem>? = null

    fun saveStores(newList: List<HomeListItem>) {
        stores = newList
    }

    fun getStores(): List<HomeListItem>? {
        return stores
    }
}