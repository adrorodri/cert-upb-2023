package com.upb.certupb2023.login.fragments.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.upb.certupb2023.TemporalDb
import com.upb.certupb2023.login.models.User

class RegisterViewModel: ViewModel() {
    init {
        println("RegisterViewModel inicializado!")
    }

    val user = MutableLiveData(User("", "", ""))
    val confirmPassword = MutableLiveData("")

    fun createUser(user: User) {
        TemporalDb.saveUser(user)
    }
}