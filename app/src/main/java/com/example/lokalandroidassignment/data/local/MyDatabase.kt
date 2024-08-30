package com.example.lokalandroidassignment.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.lokalandroidassignment.data.local.modal.BookmarkJob

@Database(entities = [BookmarkJob::class], version = 1)
@TypeConverters(Converters::class)
abstract class MyDatabase : RoomDatabase() {
    abstract fun bookmarkJobDao(): BookmarkJobDao
}