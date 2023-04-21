package com.upb.certupb2023

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.upb.certupb2023.login.models.User

object TemporalDb {
    private var user: MutableLiveData<User?> = MutableLiveData(null)

    fun saveUser(newUser: User) {
        user.value = newUser
    }

    fun observeUser(): LiveData<User?> {
        return user
    }
}