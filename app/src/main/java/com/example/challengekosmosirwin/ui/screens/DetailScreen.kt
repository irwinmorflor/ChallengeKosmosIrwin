package com.example.challengekosmosirwin.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.challengekosmosirwin.ui.components.NormalText

@Composable
fun DetailScreen(status: String?){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        NormalText(textString = status)
    }
}