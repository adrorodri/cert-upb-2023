package com.upb.certupb2023

import android.app.Application
import com.upb.certupb2023.data.api.ApiClient
import com.upb.certupb2023.data.persistency.AuthPersistency
import com.upb.certupb2023.data.persistency.RoomPersistency
import com.upb.certupb2023.data.repositories.StoresRepository
import com.upb.certupb2023.data.repositories.StoriesRepository
import com.upb.certupb2023.data.repositories.UsersRepository
import com.upb.certupb2023.login.fragments.viewmodels.RegisterViewModel
import com.upb.certupb2023.mainscreen.fragments.home.viewmodels.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App: Application() {

    val appModule = module {
        single { ApiClient() }
        single { StoresRepository(get(), get(), get()) }
        single { StoriesRepository() }
        single { UsersRepository(get(), get()) }

        single { AuthPersistency(get()) }
        single { RoomPersistency(get()) }

        viewModel { HomeViewModel(get(), get(), get()) }
        viewModel { RegisterViewModel(get()) }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}