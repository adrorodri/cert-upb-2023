package com.upb.certupb2023.login.fragments.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.upb.certupb2023.TemporalDb
import com.upb.certupb2023.data.repositories.UsersRepository
import com.upb.certupb2023.login.models.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class RegisterViewModel(val usersRepository: UsersRepository) : ViewModel() {
    init {
        println("RegisterViewModel inicializado!")
    }

    val user = MutableLiveData(User("", "", ""))
    val confirmPassword = MutableLiveData("")

    fun createUser(user: User, onSuccess: () -> Unit, onError: () -> Unit) {
//        TemporalDb.saveUser(user)
        viewModelScope.launch {
            flow {
                usersRepository.registrarUsuario(user)
                emit(user)
            }
                .flowOn(Dispatchers.IO)
                .onEach { onSuccess() }
                .catch {
                    it.printStackTrace()
                    onError()
                }
                .collect()
        }
    }

    fun login(username: String, password: String, onSuccess: () -> Unit, onError: () -> Unit) {
        viewModelScope.launch {
            flow {
                val user = usersRepository.login(username, password).first()
                emit(user)
            }
                .flowOn(Dispatchers.IO)
                .onEach { onSuccess() }
                .catch {
                    it.printStackTrace()
                    onError()
                }
                .collect()
        }
    }
}