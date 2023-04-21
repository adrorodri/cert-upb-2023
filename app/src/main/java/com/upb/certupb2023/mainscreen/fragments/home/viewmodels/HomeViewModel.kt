package com.upb.certupb2023.mainscreen.fragments.home.viewmodels

import androidx.lifecycle.ViewModel
import com.upb.certupb2023.TemporalDb

class HomeViewModel : ViewModel() {
    init {
        println("INIT HomeViewModel")
    }

    val user = TemporalDb.observeUser()
}