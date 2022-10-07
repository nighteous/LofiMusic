package com.sexymama.lofimusic.ui

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sexymama.lofimusic.R

const val connected: Boolean = true

@Composable
fun player() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .offset(0.dp, (-90).dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "LoFi Girl", color = Color.White, fontSize = 50.sp)
            Spacer(modifier = Modifier.size(40.dp))
            image()
            Spacer(modifier = Modifier.size(40.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (connected) {
                    Canvas(modifier = Modifier.size(20.dp)) {
                        drawCircle(color = Color.Green, radius = 15f)
                    }
                    Text(text = "Live", color = Color.White, fontSize = 25.sp)
                } else
                {
                    Canvas(modifier = Modifier.size(20.dp)) {
                        drawCircle(color = Color.Red, radius = 15f)
                    }
                    Text(text = "Disconnected", color = Color.White, fontSize = 25.sp)
                }
            }

            Spacer(modifier = Modifier.size(30.dp))
        }
    }
}
@Composable
fun image() {
    Image(
        painter = painterResource(id = R.drawable.lofididi),
        contentDescription = "LoFi didi Logo",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(250.dp)
            .clip(RoundedCornerShape(5.dp))
    )
}

