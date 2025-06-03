package com.example.weather.repository

import android.net.http.HttpException
import android.util.Log
import com.example.weather.model.ForecastResponse
import com.example.weather.model.Weather
import com.example.weather.model.toWeather
import com.example.weather.retrofit.WeatherAPI
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import com.example.weather.utlis.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherAPI: WeatherAPI,
    private val dispatcher: CoroutineDispatcher
    ) {
     fun getWeatherForecast(city: String): Flow<Result<Weather>> = flow {
        print("WeatherRepository called")
        emit(Result.Loading)
        Log.d("Radhe", "WeatherRepository weatherAPI response");
        try {
            val success = weatherAPI.getWeatherForecast(city = city).toWeather()
            emit(Result.Success(success))
        }catch (e: retrofit2.HttpException){
            emit(Result.Error(e.message!!))
        }catch (e:IOException){
            emit(Result.Error(e.message!!))
        }
    }.flowOn(dispatcher)
}