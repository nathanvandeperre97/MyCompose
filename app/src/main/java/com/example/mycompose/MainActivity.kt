package com.example.mycompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import coil.compose.rememberImagePainter

class MainActivity : AppCompatActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetText("Hello world!")
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun SetText(name: String) {
    Card {
        var isExpanded by remember { mutableStateOf(false) }
        Column(Modifier.clickable { isExpanded = !isExpanded }) {
            Image(
                painter = rememberImagePainter("https://fr.wikipedia.org/wiki/Twitter#/media/Fichier:Twitter_Bird.svg"),
                contentDescription = null,
            )
            AnimatedVisibility(isExpanded) {
                Text(text = "This is a bird")
            }
        }
    }
}