package com.upb.certupb2023.data.persistency

import android.content.Context
import androidx.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.upb.certupb2023.login.models.User
import com.upb.certupb2023.mainscreen.models.HomeListItem
import com.upb.certupb2023.mainscreen.models.Tag

class RoomPersistency(val context: Context) {
    val db = Room.databaseBuilder(context,
        AppRoomDatabase::class.java,
        "RoomDb.db"
    ).build()
}

@Database(entities = [HomeListItem::class, User::class], version = 1)
@TypeConverters(TagConverters::class)
abstract class AppRoomDatabase: RoomDatabase() {
    abstract fun StoresDao(): StoresDao
    abstract fun UsersDao(): UsersDao
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