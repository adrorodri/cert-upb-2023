package com.upb.certupb2023.data.persistency

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.upb.certupb2023.mainscreen.models.HomeListItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import java.lang.reflect.Type


class StoresPersistency {
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "stores")
    val STORE_LIST_KEY = stringPreferencesKey("storeList")

    val gson = Gson()

    private var stores: List<HomeListItem>? = null

    suspend fun saveStores(context: Context, newList: List<HomeListItem>) {
        context.dataStore.edit { prefs ->
            prefs[STORE_LIST_KEY] = gson.toJson(newList)
        }
    }

    suspend fun getStores(context: Context): List<HomeListItem>? {
        val storeListString = context.dataStore.data.first()[STORE_LIST_KEY]

        val listType: Type = object : TypeToken<List<HomeListItem>>() {}.type
        return gson.fromJson(storeListString, listType)
    }
}