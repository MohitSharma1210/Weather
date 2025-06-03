package com.example.weather.utlis

import com.example.weather.model.Weather

sealed class UiState {
    object Loading : UiState()
    data class Success(val data: Weather) : UiState()
    data class Error(val errorMessage: String) : UiState()
}