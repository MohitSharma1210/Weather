package com.example.weather.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import com.example.weather.R
import com.example.weather.ui.screens.components.DefaultAppBar
import com.example.weather.ui.screens.components.WeatherTopAppBar
import com.example.weather.ui.screens.components.mainscreensections.Animation
import com.example.weather.ui.screens.components.mainscreensections.CurrentWeatherSection
import com.example.weather.ui.screens.components.mainscreensections.HourlyForecast
import com.example.weather.ui.screens.components.mainscreensections.WeatherErrorState
import com.example.weather.ui.screens.components.mainscreensections.WeatherMetrics
import com.example.weather.ui.screens.components.mainscreensections.WeeklyForecast
import com.example.weather.utlis.SearchWidgetState
import com.example.weather.utlis.UiState
import com.example.weather.viewmodel.WeatherViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun WeatherScreen(viewModel: WeatherViewModel = hiltViewModel()) {
    val searchWidgetState by viewModel.searchWidgetState
    val searchTextState by viewModel.searchTextState
    Scaffold(
        topBar = { WeatherTopAppBar(
            searchWidgetState = searchWidgetState,
            searchTextState = searchTextState,
            onTextChange = { viewModel.updateSearchTextState(it) },
            onCloseClicked = { viewModel.updateSearchWidgetState(SearchWidgetState.CLOSED) },
            onSearchClicked = { viewModel.getWeather(it) },
            onSearchTriggered = {
                viewModel.updateSearchWidgetState(newValue = SearchWidgetState.OPENED)
            }
        )
                 },
        content = { paddingValues ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                color = MaterialTheme.colorScheme.background,
            ) {

                MainScreen(viewModel)
            }
        },
    )
}
