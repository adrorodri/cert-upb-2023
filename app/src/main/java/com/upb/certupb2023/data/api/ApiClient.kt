package com.upb.certupb2023.data.api

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.upb.certupb2023.mainscreen.models.HomeListItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import me.sianaki.flowretrofitadapter.FlowCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url


interface Api {
    @GET("stores/list")
    fun getStoresList(): Flow<List<HomeListItem>>

    @GET("stores/{id}")
    fun getStoreById(@Url id: String): Flow<List<HomeListItem>>
}

class ApiClient {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://10.100.1.18:8000/")
        .addCallAdapterFactory(FlowCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val client = retrofit.create(Api::class.java)

    fun getStoresList(): Flow<List<HomeListItem>> {
        return client.getStoresList().map {
            println(it)
            it
//            val listType = object : TypeToken<List<HomeListItem>>() {}.type
//            Gson().fromJson(it, listType)
        }
    }
}