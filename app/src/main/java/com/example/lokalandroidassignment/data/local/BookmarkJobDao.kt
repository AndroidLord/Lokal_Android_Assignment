package com.example.lokalandroidassignment.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.lokalandroidassignment.data.local.modal.BookmarkJob
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkJobDao {

    // CRUD operations for BookmarkJob
    // Create
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBookmarkJob(bookmarkJob: BookmarkJob)

    // Read

    @Query("SELECT * FROM bookmark_job")
    fun getAllBookmarkJobs(): Flow<List<BookmarkJob>>

    // Delete
    @Delete
    suspend fun deleteBookmarkJob(bookmarkJob: BookmarkJob)

}


