package com.upb.certupb2023.data.persistency

import android.content.Context
import androidx.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.upb.certupb2023.login.models.User
import com.upb.certupb2023.mainscreen.models.HomeListItem
import com.upb.certupb2023.mainscreen.models.Tag


@Database(entities = [HomeListItem::class, User::class], version = 1)
@TypeConverters(TagConverters::class)
abstract class RoomPersistency: RoomDatabase() {

    abstract fun StoresDao(): StoresDao

    abstract fun UsersDao(): UsersDao

    companion object {
        var instance: RoomPersistency? = null

        fun getInstance(context: Context): RoomPersistency {
            if (instance == null) {
                instance = Room.databaseBuilder(context,
                    RoomPersistency::class.java,
                    "RoomDb.db"
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