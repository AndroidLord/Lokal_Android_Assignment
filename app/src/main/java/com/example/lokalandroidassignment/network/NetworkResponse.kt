package com.example.lokalandroidassignment.network

sealed class NetworkResponse<out T> {
    data class Success<out T>(val value: T) : NetworkResponse<T>()
    data class Error(val exception: Exception) : NetworkResponse<Nothing>()
    data object Loading : NetworkResponse<Nothing>()
}