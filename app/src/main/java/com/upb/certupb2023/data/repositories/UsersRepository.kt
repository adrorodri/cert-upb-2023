package com.upb.certupb2023.data.repositories

import android.content.Context
import com.upb.certupb2023.data.persistency.AuthPersistency
import com.upb.certupb2023.data.persistency.AppRoomDatabase
import com.upb.certupb2023.data.persistency.RoomPersistency
import com.upb.certupb2023.login.models.User
import kotlinx.coroutines.flow.*

class UsersRepository(val roomPersistency: RoomPersistency, val authPersistency: AuthPersistency) {

    suspend fun registrarUsuario(user: User) {
        roomPersistency.db.UsersDao().insertUser(user)
        authPersistency.saveUser(user)
    }

    fun login(username: String, password: String): Flow<User> {
        return roomPersistency.db.UsersDao().getUser(username, password)
            .map { it.first() }
            .onEach { user -> authPersistency.saveUser(user) }
    }

    fun logout(): Flow<Unit> {
        return flow {
            authPersistency.removeUser()
        }
    }

    suspend fun isLoggedIn(): Boolean {
        return authPersistency.getUser()?.first() != null
    }

    suspend fun updatePassword(username: String, oldPassword: String, newPassword: String) {
        val user = roomPersistency.db.UsersDao().getUser(username, oldPassword).map { it.first() }.first()
        user.password = newPassword
        roomPersistency.db.UsersDao().updateUser(user)
    }
}