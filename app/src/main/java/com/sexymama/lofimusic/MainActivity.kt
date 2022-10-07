package com.sexymama.lofimusic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sexymama.lofimusic.ui.player
import com.sexymama.lofimusic.ui.theme.LoFiMusicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoFiMusicTheme {
                player()
            }
        }
    }
}