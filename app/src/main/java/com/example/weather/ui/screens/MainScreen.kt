package com.example.weather.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.ui.screens.components.mainscreensections.CurrentWeatherSection
import com.example.weather.ui.screens.components.mainscreensections.HourlyForecast
import com.example.weather.ui.screens.components.mainscreensections.WeatherMetrics
import com.example.weather.ui.screens.components.mainscreensections.WeeklyForecast
import com.example.weather.viewmodel.WeatherViewModel

@Composable
fun MainScreen(viewModel: WeatherViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.DarkGray)
            .padding(top = 24.dp),
    ) {
        CurrentWeatherSection(viewModel)
        WeatherMetrics(viewModel)
        HourlyForecast(viewModel)
        WeeklyForecast(viewModel)
    }
}
