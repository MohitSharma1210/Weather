package com.example.weather.ui.screens.components.mainscreensections

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.weather.model.Forecast
import com.example.weather.model.Hour
import com.example.weather.R
import com.example.weather.ui.screens.components.ForecastComponent
import com.example.weather.utlis.UiState
import com.example.weather.viewmodel.WeatherViewModel
import kotlin.random.Random

@Composable
fun WeeklyForecast(viewModel: WeatherViewModel,uiState: UiState){
    val weatherData = (uiState as UiState.Success).data
    Spacer(Modifier.height(16.dp))
    Text(
        text = stringResource(R.string.forecast),
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier
            .padding(horizontal = 16.dp),
    )

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(top = 8.dp, start = 16.dp),
    ) {
        items(weatherData.forecasts) { forecast ->
            ForecastComponent(
                date = forecast.date,
                icon = forecast.icon,
                minTemp = stringResource(
                    R.string.temperature_value_in_celsius,
                    forecast.minTemp
                ),
                maxTemp = stringResource(
                    R.string.temperature_value_in_celsius,
                    forecast.maxTemp,
                ),
            )
        }
    }
    Spacer(Modifier.height(16.dp))
}