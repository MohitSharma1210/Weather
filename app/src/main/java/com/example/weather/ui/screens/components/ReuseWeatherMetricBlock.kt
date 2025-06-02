package com.example.weather.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
