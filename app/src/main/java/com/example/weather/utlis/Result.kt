package com.example.weather.utlis

sealed class Result<out T : Any> {
    object Loading : Result<Nothing>()
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val errorMessage: String) : Result<Nothing>()
}
