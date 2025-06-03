package com.example.weather.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.repository.WeatherRepository
import com.example.weather.utlis.DEFAULT_WEATHER_DESTINATION
import com.example.weather.utlis.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import com.example.weather.utlis.Result
import com.example.weather.utlis.SearchWidgetState
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _searchWidgetState: MutableState<SearchWidgetState> =
        mutableStateOf(value = SearchWidgetState.CLOSED)
    val searchWidgetState: State<SearchWidgetState> = _searchWidgetState

    private val _searchTextState: MutableState<String> = mutableStateOf(value = "")
    val searchTextState: State<String> = _searchTextState

    fun updateSearchWidgetState(newValue: SearchWidgetState) {
        _searchWidgetState.value = newValue
    }

    fun updateSearchTextState(newValue: String) {
        _searchTextState.value = newValue
    }

    init {
        Log.d("Radhe", "WeatherViewModel called");
        getWeather()

    }

    fun getWeather(city: String = DEFAULT_WEATHER_DESTINATION) {

        val cities = listOf("Bangalore", "Hyderabad", "Kota Rajasthan", "Jaipur", "Noida", "Delhi")
        var randomCity = cities.randomOrNull().orEmpty()

        if (city != DEFAULT_WEATHER_DESTINATION) randomCity = city

        weatherRepository.getWeatherForecast(randomCity).map { result ->
            Log.d("Radhe", "WeatherViewModel result "+result);
            when (result) {
                is Result.Success -> {
                    _uiState.value = UiState.Success(result.data)
                }

                is Result.Error -> {
                    _uiState.value = UiState.Error(result.errorMessage)
                }

                Result.Loading -> {
                    _uiState.value = UiState.Loading
                }
            }
        }.launchIn(viewModelScope)
    }
}