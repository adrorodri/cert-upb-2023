package com.upb.certupb2023.login.models

import androidx.databinding.BaseObservable

class User(username: String, email: String, password: String) : BaseObservable() {
    var username: String = username
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