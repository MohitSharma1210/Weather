package com.example.weather.retrofit

import com.example.weather.BuildConfig
import com.example.weather.model.ForecastResponse
import com.example.weather.utlis.DEFAULT_WEATHER_DESTINATION
import com.example.weather.utlis.NUMBER_OF_DAYS
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("forecast.json")
    suspend fun getWeatherForecast(
        @Query("key") key: String = BuildConfig.API_KEY,
        @Query("q") city: String = DEFAULT_WEATHER_DESTINATION,
        @Query("days") days: Int = NUMBER_OF_DAYS,
    ): ForecastResponse
}