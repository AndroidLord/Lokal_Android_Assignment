package com.example.lokalandroidassignment.data.remote

import com.example.lokalandroidassignment.data.remote.model.JobEntity
import com.example.lokalandroidassignment.utils.JOB_PATH
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface JobApi {

    @GET(JOB_PATH)
    suspend fun getJobs(
        @Query("page") page: Int=1,
    ): Response<JobEntity>

}