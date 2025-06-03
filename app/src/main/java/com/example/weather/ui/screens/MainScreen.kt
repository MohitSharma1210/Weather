package com.example.weather.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import com.example.weather.R
import com.example.weather.ui.screens.components.mainscreensections.Animation
import com.example.weather.ui.screens.components.mainscreensections.CurrentWeatherSection
import com.example.weather.ui.screens.components.mainscreensections.HourlyForecast
import com.example.weather.ui.screens.components.mainscreensections.WeatherErrorState
import com.example.weather.ui.screens.components.mainscreensections.WeatherMetrics
import com.example.weather.ui.screens.components.mainscreensections.WeeklyForecast
import com.example.weather.utlis.UiState
import com.example.weather.viewmodel.WeatherViewModel

@Composable
fun MainScreen(viewModel: WeatherViewModel = hiltViewModel()) {
   val uiState: UiState by viewModel.uiState.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.DarkGray)
            .padding(top = 24.dp),
    ) {
        when(uiState){
           is UiState.Loading -> {
                Animation(modifier = Modifier.fillMaxSize(), animation = R.raw.animation_loading)
            }

           is UiState.Success -> {
                CurrentWeatherSection(viewModel,uiState)
                WeatherMetrics(viewModel,uiState)
                HourlyForecast(viewModel,uiState)
                WeeklyForecast(viewModel,uiState)
            }

           is UiState.Error ->{
               WeatherErrorState(viewModel,uiState)
           }
        }
    }
}
