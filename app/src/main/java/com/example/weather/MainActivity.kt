package com.example.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.ui.theme.WeatherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherTheme {
                MainScreen()
            }
        }
    }
}


@Composable
fun MainScreen(){
   Column(
       modifier = Modifier.fillMaxSize()
           .background(Color.DarkGray)
           .padding(top = 24.dp)

   ) {
       TopBar()
   }
}

@Composable
fun TopBar(){
    Row(
     modifier = Modifier.fillMaxWidth().size(50.dp).background(Color.Cyan)
         .padding(top = 16.dp, bottom = 10.dp, start = 16.dp, end = 16.dp),
     verticalAlignment = Alignment.CenterVertically,
     horizontalArrangement = Arrangement.Start
    ) {
        Text(text = "Weather App",
            textAlign = TextAlign.Left ,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(Icons.Default.Search, contentDescription = "search icon", modifier = Modifier.size(30.dp))
    }
}

@Composable
fun CurrentWeatherSection(){

}



