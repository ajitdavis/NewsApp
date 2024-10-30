package com.example.newsgenz.model.room

import androidx.room.TypeConverter
import com.example.newsgenz.model.Source
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {

    @TypeConverter
    fun fromSource(source: Source):String? {
        return if(source == null) {
            return null
        } else {
            Gson().toJson(source)
        }
    }

    @TypeConverter
    fun toSource(sourceString: String): Source? {
        return if(sourceString==null)
            return null
        else{
            val type = object : TypeToken<Source>(){}.type
            Gson().fromJson(sourceString,type)
        }
    }
}