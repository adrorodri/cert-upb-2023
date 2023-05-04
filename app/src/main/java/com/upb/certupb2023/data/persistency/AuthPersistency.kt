package com.upb.certupb2023.data.persistency

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.upb.certupb2023.login.models.User
import kotlinx.coroutines.flow.first


object AuthPersistency {
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "auth")
    val tokenKey = stringPreferencesKey("tokenKey")

    suspend fun saveUser(context: Context, user: User) {
        context.dataStore.edit { prefs ->
            prefs[tokenKey] = user.username
        }
    }

    suspend fun getUser(context: Context): String? {
        return context.dataStore.data.first()[tokenKey]
    }

    suspend fun removeUser(context: Context) {
        context.dataStore.edit { prefs ->
            prefs.remove(tokenKey)
        }
    }
}