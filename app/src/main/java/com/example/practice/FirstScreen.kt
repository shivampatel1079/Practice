package com.example.practice

import android.window.SplashScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.practice.navigation.FirstScreen
import com.example.practice.navigation.SecondScreen

@Composable
fun FirstScreen(
    onGoingToScreen2 : () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
                onGoingToScreen2()
        }) {
            Text("GO to SC2")
        }
    }
}

@Composable
fun SecondScreen(
    onGoingToScreen1 : () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(Color.Green),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
                onGoingToScreen1()
        }) {
            Text("GO to SC1")
        }
    }
}