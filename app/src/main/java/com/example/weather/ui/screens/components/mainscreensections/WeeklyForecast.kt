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
import com.example.weather.viewmodel.WeatherViewModel
import kotlin.random.Random

@Composable
fun WeeklyForecast(viewModel: WeatherViewModel){
    Spacer(Modifier.height(16.dp))
    Text(
        text = stringResource(R.string.forecast),
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier
            .padding(horizontal = 16.dp),
    )

    val forecastList = listOf(
        Forecast(
            date = "2025-05-${String.format("%02d", 1)}",
            maxTemp = "30°C",
            minTemp = "20°C",
            sunrise = "06:00 AM",
            sunset = "07:30 PM",
            icon = "sunny",
            hour = listOf(
                Hour("06 AM", "sunny", "20°C"),
                Hour("09 AM", "sunny", "23°C"),
                Hour("12 PM", "sunny", "28°C"),
                Hour("03 PM", "sunny", "30°C"),
                Hour("06 PM", "cloudy", "27°C"),
                Hour("09 PM", "clear", "22°C"),
            )
        ),
        Forecast(
            date = "2025-05-${String.format("%02d", 2)}",
            maxTemp = "28°C",
            minTemp = "18°C",
            sunrise = "06:01 AM",
            sunset = "07:31 PM",
            icon = "partly_cloudy",
            hour = listOf(
                Hour("06 AM", "cloudy", "18°C"),
                Hour("09 AM", "partly_cloudy", "22°C"),
                Hour("12 PM", "sunny", "26°C"),
                Hour("03 PM", "sunny", "28°C"),
                Hour("06 PM", "cloudy", "25°C"),
                Hour("09 PM", "clear", "20°C"),
            )
        ),
        Forecast(
            date = "2025-05-${String.format("%02d", 3)}",
            maxTemp = "28°C",
            minTemp = "18°C",
            sunrise = "06:01 AM",
            sunset = "07:31 PM",
            icon = "partly_cloudy",
            hour = listOf(
                Hour("06 AM", "cloudy", "18°C"),
                Hour("09 AM", "partly_cloudy", "22°C"),
                Hour("12 PM", "sunny", "26°C"),
                Hour("03 PM", "sunny", "28°C"),
                Hour("06 PM", "cloudy", "25°C"),
                Hour("09 PM", "clear", "20°C"),
            )
        )
    )



    val hourlyForecast = mutableListOf<Hour>()
    for (i in 0 until 24) {
        hourlyForecast.add(
            Hour(
                "yyyy-mm-dd ${String.format("%02d", i)}",
                "",
                "${Random.nextInt(18, 21)}"
            )
        )
    }
    val forecasts = mutableListOf<Forecast>()
    for (i in 0..9) {
        forecasts.add(
            Forecast(
                "2023-10-${String.format("%02d", i)}",
                "${Random.nextInt(18, 21)}",
                "${Random.nextInt(10, 15)}",
                "07:20 am",
                "06:40 pm",
                "",
                hourlyForecast
            )
        )
    }



    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(top = 8.dp, start = 16.dp),
    ) {

        items(forecasts) { forecast ->
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