package com.upb.certupb2023.data.repositories

import android.content.Context
import com.upb.certupb2023.data.persistency.RoomPersistency
import com.upb.certupb2023.login.models.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class UsersRepository {
    fun registrarUsuario(context: Context, user: User) {
        RoomPersistency.getInstance(context).UsersDao().insertUser(user)
    }

    fun login(context: Context, username: String, password: String): Flow<User> {
        return RoomPersistency.getInstance(context).UsersDao().getUser(username, password).map { it.first() }
    }

    suspend fun updatePassword(context: Context, username: String, oldPassword: String, newPassword: String) {
        val user = RoomPersistency.getInstance(context).UsersDao().getUser(username, oldPassword).map { it.first() }.first()
        user.password = newPassword
        RoomPersistency.getInstance(context).UsersDao().updateUser(user)
    }
}