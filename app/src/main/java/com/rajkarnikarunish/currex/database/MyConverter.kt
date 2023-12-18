package com.rajkarnikarunish.currex.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MyConverter {

    @TypeConverter
    fun jsonToMap(value: String): Map<String, Double>? {
        val mapType = object : TypeToken<Map<String, Double>?>() {}.type
        return Gson().fromJson(value, mapType)
    }

    @TypeConverter
    fun mapToJson(map: Map<String, Double>?): String {
        val gson = Gson()
        return gson.toJson(map)
    }
}