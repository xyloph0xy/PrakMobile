package com.luluksofiyah.uas.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.luluksofiyah.uas.data.source.local.entity.FilmEntity
import com.luluksofiyah.uas.utilities.Constants.DB_VERSION

@Database(
    entities = [FilmEntity::class],
    version = DB_VERSION,
    exportSchema = false
)

@TypeConverters(Converters::class)
abstract class FilmDB : RoomDatabase() {
    abstract fun FilmGet(): FilmGet
}

class Converters {

    @TypeConverter
    fun fromString(value: String?): List<Int>? {
        if (value == null) {
            return emptyList()
        }
        val listType = object : TypeToken<List<Int>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun toString(list: List<Int>?): String {
        return Gson().toJson(list)
    }
}