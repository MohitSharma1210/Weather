package com.example.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.items

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weather.DateUtil.toFormattedDate
import com.example.weather.ui.theme.WeatherTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherTheme {
                Scaffold(
                    topBar = { DefaultAppBar() },
                    content = { paddingValues ->
                        Surface(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(paddingValues),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            MainScreen()
                        }
                    },
                )
            }
        }
    }
}


@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(top = 24.dp)

    ) {
        CurrentWeatherSection()
        WeatherMetrics()
        HourlyForecast()
        WeeklyForecast()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultAppBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                fontWeight = FontWeight.Bold,
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
        ),
        actions = {
            IconButton(
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null,
                )
            }
        }
    )
}




@Composable
fun CurrentWeatherSection() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Tokyo",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(top = 15.dp)
        )
        Text(
            text = "Oct 16",
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White
        )
        Image(
            painter = painterResource(id = R.drawable.ic_placeholder),
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )
        val temperature = 19
        Text(
            text = "$temperature°",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            "Partly cloudy\nFeels like 14°C",
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
                Text("05:48 am", color = Color.White)
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_sunset),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("05:05 pm", color = Color.White)
            }
        }
    }
}

@Composable
fun WeatherMetrics() {
    Spacer(Modifier.height(16.dp))
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ReuseWeatherMetricBlock("Wind Speed", R.drawable.ic_wind,13, "km/h")
        ReuseWeatherMetricBlock("UV", R.drawable.ic_uv,5, "index")
        ReuseWeatherMetricBlock("Humidity", R.drawable.ic_humidity,82, "percentage %")
    }
}

@Composable
fun HourlyForecast(){
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

    LazyRow(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp))
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

@Composable
fun WeeklyForecast(){
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



@Composable
fun ForecastComponent(
    modifier: Modifier = Modifier,
    date: String,
    icon: String,
    minTemp: String,
    maxTemp: String,
) {
    ElevatedCard(
        modifier = modifier.padding(end = 16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                text = date.toFormattedDate().orEmpty(),
                style = MaterialTheme.typography.titleMedium
            )
            Image(
                modifier = Modifier.size(42.dp),
                painter = painterResource(R.drawable.ic_placeholder),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Text(
                text = maxTemp,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
            )
            Spacer(Modifier.width(4.dp))

            Text(
                text = minTemp, style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
fun HourlyComponent(
    modifier: Modifier = Modifier,
    time: String,
    icon: String,
    temperature: String,
) {
    ElevatedCard(
        modifier = modifier.padding(end = 12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = time,
                style = MaterialTheme.typography.titleMedium,
            )
            Image(
                modifier = Modifier.size(42.dp),
                painter = painterResource(id = R.drawable.ic_placeholder),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                )
            Text(
                text = temperature,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }

}


@Composable
fun ReuseWeatherMetricBlock(
    titleText: String,
    imageId: Int,
    valueText: Int,
    unitText: String
) {
    ElevatedCard(
        modifier = Modifier.size(110.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = titleText,
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 12.sp
            )
            Image(
                painter = painterResource(id = imageId),
                contentDescription = null
            )
            Text(
                text = valueText.toString(),
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 12.sp
            )
            Text(
                text = unitText,
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 12.sp,
                lineHeight = 12.sp
            )
        }
    }
}






