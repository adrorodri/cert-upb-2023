package com.upb.certupb2023.data.persistency

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.upb.certupb2023.login.models.User
import kotlinx.coroutines.flow.first


class AuthPersistency(val context: Context) {
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "auth")
    val tokenKey = stringPreferencesKey("tokenKey")

    suspend fun saveUser(user: User) {
        context.dataStore.edit { prefs ->
            prefs[tokenKey] = user.username
        }
    }

    suspend fun getUser(): String? {
        return context.dataStore.data.first()[tokenKey]
    }

    suspend fun removeUser() {
        context.dataStore.edit { prefs ->
            prefs.remove(tokenKey)
        }
    }
}