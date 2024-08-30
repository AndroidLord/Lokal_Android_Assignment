package com.example.lokalandroidassignment.data.local

import androidx.room.TypeConverter
import com.example.lokalandroidassignment.data.remote.model.Creative
import com.example.lokalandroidassignment.data.remote.model.JobTag
import com.example.lokalandroidassignment.data.remote.model.V3
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    // Converter for List<V3>
    @TypeConverter
    fun toV3List(value: String?): List<V3>? {
        val listType = object : TypeToken<List<V3>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromListV3(list: List<V3>?): String? {
        return Gson().toJson(list)
    }

    // Converter for List<Creative>
    @TypeConverter
    fun toCreativeList(value: String?): List<Creative>? {
        val listType = object : TypeToken<List<Creative>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromListCreative(list: List<Creative>?): String? {
        return Gson().toJson(list)
    }

    // Converter for List<JobTag>
    @TypeConverter
    fun toJobTagList(value: String?): List<JobTag>? {
        val listType = object : TypeToken<List<JobTag>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromListJobTag(list: List<JobTag>?): String? {
        return Gson().toJson(list)
    }
}