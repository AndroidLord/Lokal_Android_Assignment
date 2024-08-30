package com.example.lokalandroidassignment.data.local.repository

import com.example.lokalandroidassignment.data.local.BookmarkJobDao
import com.example.lokalandroidassignment.data.local.modal.BookmarkJob
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookmarkRepository @Inject constructor(
    private val bookmarkJobDao: BookmarkJobDao
) {

    // CRUD operations for BookmarkJob
    // Create
    suspend fun insertBookmarkJob(bookmarkJob: BookmarkJob) {
        bookmarkJobDao.insertBookmarkJob(bookmarkJob)
    }

    // Read
    fun getAllBookmarkJobs() : Flow<List<BookmarkJob>> = bookmarkJobDao.getAllBookmarkJobs()

    // Delete
    suspend fun deleteBookmarkJob(bookmarkJob: BookmarkJob) {
        bookmarkJobDao.deleteBookmarkJob(bookmarkJob)
    }

}