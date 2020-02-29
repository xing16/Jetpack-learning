package com.xing.jetpack.room.converters

import androidx.room.TypeConverter
import com.google.gson.Gson

class ListConverter {

    @TypeConverter
    fun list2String(list: ArrayList<*>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun string2List(string: String): List<*> {
        return Gson().fromJson(string, List::class.java)
    }


}