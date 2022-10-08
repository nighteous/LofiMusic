package com.sexymama.lofimusic.ui

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sexymama.lofimusic.R
import java.io.IOException

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
                } else {
                    Canvas(modifier = Modifier.size(20.dp)) {
                        drawCircle(color = Color.Red, radius = 15f)
                    }
                    Text(text = "Disconnected", color = Color.White, fontSize = 25.sp)
                }
            }

            Spacer(modifier = Modifier.size(30.dp))

            button()
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

@Composable
fun button() {

    val context = LocalContext.current

    OutlinedButton(
        onClick = {
            val url = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"
            val mediaPlayer = MediaPlayer()
            mediaPlayer.setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build()
            )

            try {
                mediaPlayer.setDataSource(context, Uri.parse(url))
                mediaPlayer.prepareAsync()
                mediaPlayer.setOnPreparedListener { mp ->
                    mp.start()
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }

        },
        modifier = Modifier.size(70.dp),
        shape = CircleShape,
        border = BorderStroke(5.dp, Color(0XFF0F9D58)),
    ) {
        Text(text = "Play", color = Color.Blue)
    }
}

