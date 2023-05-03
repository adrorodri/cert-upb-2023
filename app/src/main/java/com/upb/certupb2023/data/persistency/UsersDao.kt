package com.upb.certupb2023.data.persistency

import androidx.room.*
import com.upb.certupb2023.login.models.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertUser(user: User)

    @Query("SELECT * FROM User WHERE username = :username AND password = :password")
    fun getUser(username: String, password: String): Flow<List<User>>

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)
}