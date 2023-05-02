package com.upb.certupb2023.data.persistency

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.upb.certupb2023.mainscreen.models.HomeListItem
import com.upb.certupb2023.mainscreen.models.Tag
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import java.lang.reflect.Type


@Database(entities = [HomeListItem::class], version = 1)
@TypeConverters(TagConverters::class)
abstract class StoresPersistency: RoomDatabase() {

    abstract fun StoresDao(): StoresDao

    companion object {
        var instance: StoresPersistency? = null

        fun getInstance(context: Context): StoresPersistency {
            if (instance == null) {
                instance = Room.databaseBuilder(context,
                    StoresPersistency::class.java,
                    "StoresDb.db"
                ).build()
            }
            return instance!!
        }
    }
}

class TagConverters {
    @TypeConverter
    fun tagsToString(tags: List<Tag>): String {
        return Gson().toJson(tags)
    }

    @TypeConverter
    fun stringToTags(tagsString: String): List<Tag> {
        val listType = object : TypeToken<List<Tag>>() {}.type
        return Gson().fromJson(tagsString, listType)
    }
}