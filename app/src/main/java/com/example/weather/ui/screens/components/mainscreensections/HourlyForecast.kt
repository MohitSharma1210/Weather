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
import androidx.compose.ui.unit.dp
import com.example.weather.model.Hour
import com.example.weather.ui.screens.components.HourlyComponent
import com.example.weather.viewmodel.WeatherViewModel

@Composable
fun HourlyForecast(viewModel: WeatherViewModel){
    Spacer(Modifier.height(16.dp))
    Text(text = "Today",
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier
            .padding(horizontal = 16.dp),
    )
    val hourlyResult:MutableList<Hour> = mutableListOf(
        Hour("00","R.drawable.ic_uv","14°"),
        Hour("01","R.drawable.ic_uv","14°"),
        Hour("02","R.drawable.ic_uv","14°"),
        Hour("03","R.drawable.ic_uv","14°"),
        Hour("04","R.drawable.ic_uv","14°"),
        Hour("05","R.drawable.ic_uv","14°"),
        Hour("06","R.drawable.ic_uv","14°"),
        Hour("07","R.drawable.ic_uv","14°"),
        Hour("08","R.drawable.ic_uv","14°")

    )

    LazyRow(modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(top = 8.dp, start = 16.dp))
    {
        items(hourlyResult) { hour ->
            HourlyComponent(
                time = hour.time,
                icon = hour.icon,
                temperature = hour.temperature
            )
        }
    }
}
