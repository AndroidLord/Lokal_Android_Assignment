package com.example.lokalandroidassignment.di

import android.content.Context
import androidx.room.Room
import com.example.lokalandroidassignment.data.local.BookmarkJobDao
import com.example.lokalandroidassignment.data.local.MyDatabase
import com.example.lokalandroidassignment.utils.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): MyDatabase {
        return Room.databaseBuilder(
            context,
            MyDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideBookmarkJobDao(database: MyDatabase): BookmarkJobDao
    = database.bookmarkJobDao()

}