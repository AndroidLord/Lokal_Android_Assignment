package com.example.lokalandroidassignment.ui.screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lokalandroidassignment.data.local.modal.BookmarkJob
import com.example.lokalandroidassignment.data.local.repository.BookmarkRepository
import com.example.lokalandroidassignment.data.remote.model.JobEntity
import com.example.lokalandroidassignment.data.remote.model.ResultModal
import com.example.lokalandroidassignment.data.remote.repository.JobRepository
import com.example.lokalandroidassignment.network.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: JobRepository,
    private val bookmarkRepository: BookmarkRepository
) : ViewModel() {

    init {
        getJobs()
    }

    private val _jobs: MutableStateFlow<NetworkResponse<JobEntity>> =
        MutableStateFlow(NetworkResponse.Loading)
    val jobs: StateFlow<NetworkResponse<JobEntity>> = _jobs


    private var currentPage = 1
    var isLastPage by mutableStateOf(false)

    fun loadNextPage() {
        getJobs()
    }

    private fun getJobs() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getJobs(currentPage)
            _jobs.value = when {
                response.isSuccessful -> {
                    response.body()?.let { jobEntity ->
                        when (jobEntity.results.size) {
                            0 -> isLastPage = true
                            else -> currentPage++
                        }
                        val currentJobs =
                            (_jobs.value as? NetworkResponse.Success)?.value?.results.orEmpty()
                        val updatedJobs = currentJobs + jobEntity.results
                        NetworkResponse.Success(jobEntity.copy(results = updatedJobs))

                    } ?: NetworkResponse.Error(Exception("No data found"))
                }

                else -> {
                    val exception = Exception(response.message())
                    NetworkResponse.Error(exception)
                }
            }
            Log.d("MainViewModel", "getJobs: ${response.body()?.results?.size ?: 0}")
        }
    }

    fun getJobById(jobId: Long): ResultModal? {
        return when (val jobResponse = jobs.value) {
            is NetworkResponse.Success -> {
                jobResponse.value.results.find { it.id == jobId }
            }

            else -> null
        }
    }

    fun getBookmarkJobById(jobId: Long): BookmarkJob? {
        return bookmarkJob.value.find { it.id == jobId }
    }


    // <---------------------------------Bookmark Job------------------------------------>

    init {
        getAllBookmarkJobs()
    }

    fun toggleBookmarkJob(jobId: Long) {
        val job = getJobById(jobId)
        job?.let {
            val bookmarkJob = it.toBookmarkJob()
            if (getBookmarkJobById(jobId) == null) {
                addBookmarkJob(bookmarkJob)
            } else {
                removeBookmarkJob(bookmarkJob)
            }
        }
    }

    private val _bookmarkJob: MutableStateFlow<List<BookmarkJob>> = MutableStateFlow(emptyList())
    val bookmarkJob: StateFlow<List<BookmarkJob>>
        get() = _bookmarkJob

    // Crud operations for BookmarkJob
    // Create
    fun addBookmarkJob(bookmarkJob: BookmarkJob) {
        viewModelScope.launch(Dispatchers.IO) {
            bookmarkRepository.insertBookmarkJob(bookmarkJob)
        }
    }

    // Read
    private fun getAllBookmarkJobs() {
        viewModelScope.launch(Dispatchers.IO) {
            bookmarkRepository.getAllBookmarkJobs().collect {
                _bookmarkJob.value = it
            }
        }
    }

    // Delete
    fun removeBookmarkJob(bookmarkJob: BookmarkJob) {
        viewModelScope.launch(Dispatchers.IO) {
            bookmarkRepository.deleteBookmarkJob(bookmarkJob)
        }
    }

}