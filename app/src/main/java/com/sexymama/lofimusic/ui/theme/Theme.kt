package com.sexymama.lofimusic.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = Color.Black,
    primaryVariant = Color.Black,
    secondary = Color.Black
)

private val LightColorPalette = lightColors(
    primary = Color.Black,
    primaryVariant = Color.Black,
    secondary = Color.Black

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun LoFiMusicTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val systemUiController = rememberSystemUiController()
    if(darkTheme){
        systemUiController.setSystemBarsColor(
            color = Color.Black
        )
    }else{
        systemUiController.setSystemBarsColor(
            color = Color.Black
        )
    }


    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}