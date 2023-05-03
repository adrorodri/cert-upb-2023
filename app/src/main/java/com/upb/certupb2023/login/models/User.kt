package com.upb.certupb2023.login.models

import androidx.databinding.BaseObservable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(username: String, email: String, password: String) : BaseObservable() {
    @PrimaryKey var username: String = username
        set(value) {
            field = value
            notifyChange()
        }

    var email: String = email
        set(value) {
            field = value
            notifyChange()
        }

    var password: String = password
        set(value) {
            field = value
            notifyChange()
        }
}