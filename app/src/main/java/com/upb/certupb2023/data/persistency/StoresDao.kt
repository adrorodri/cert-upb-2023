package com.upb.certupb2023.data.persistency

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.upb.certupb2023.mainscreen.models.HomeListItem
import kotlinx.coroutines.flow.Flow

@Dao
interface StoresDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveStores(newList: List<HomeListItem>)

    @Query("SELECT * FROM HomeListItem")
    fun getStores(): Flow<List<HomeListItem>>

    @Query("SELECT * FROM HomeListItem WHERE title LIKE '%' || :searchStr || '%'")
    fun searchStores(searchStr: String): Flow<List<HomeListItem>>
}