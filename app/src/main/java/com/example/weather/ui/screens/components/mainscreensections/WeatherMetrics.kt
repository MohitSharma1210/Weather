package com.example.weather.ui.screens.components.mainscreensections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weather.R
import com.example.weather.ui.screens.components.ReuseWeatherMetricBlock
import com.example.weather.utlis.UiState
import com.example.weather.viewmodel.WeatherViewModel

@Composable
fun WeatherMetrics(viewModel: WeatherViewModel, uiState:UiState) {
    Spacer(Modifier.height(16.dp))
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val weatherData = (uiState as UiState.Success).data
        ReuseWeatherMetricBlock("Wind Speed", R.drawable.ic_wind,weatherData.wind, "km/h")
        ReuseWeatherMetricBlock("UV", R.drawable.ic_uv,weatherData.uv, "index")
        ReuseWeatherMetricBlock("Humidity", R.drawable.ic_humidity,weatherData.humidity, "percentage %")
    }
}