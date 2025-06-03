package com.example.weather.ui.screens.components.mainscreensections

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weather.R
import com.example.weather.utlis.DateUtil.toFormattedDate
import com.example.weather.utlis.UiState
import com.example.weather.viewmodel.WeatherViewModel
import java.util.Locale

@Composable
fun CurrentWeatherSection(viewModel: WeatherViewModel, uiState:UiState) {
    val weatherData = (uiState as UiState.Success).data
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = weatherData.name,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(top = 15.dp)
        )
        Text(
            text = weatherData.date.toFormattedDate(),
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White
        )
        Log.d("Radhe", weatherData.condition.icon)
        AsyncImage(
            modifier = Modifier.size(64.dp),
            model = stringResource(
                R.string.icon_image_url,
                weatherData.condition.icon,
            ),
            contentScale = ContentScale.FillBounds,
            contentDescription = null,
            error = painterResource(id = R.drawable.ic_placeholder),
            placeholder = painterResource(id = R.drawable.ic_placeholder),
        )
        Text(
            text = stringResource(
                R.string.temperature_value_in_celsius,
                weatherData.temperature,
            ),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            "Partly cloudy\nFeels like ${
                stringResource(
                    R.string.temperature_value_in_celsius,
                    weatherData.feelsLike,
                )
            }",
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 13.sp,
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_sunrise),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(weatherData.forecasts[0].sunrise.lowercase(Locale.US), color = Color.White)
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_sunset),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(weatherData.forecasts[0].sunset.lowercase(Locale.US), color = Color.White)
            }
        }
    }
}