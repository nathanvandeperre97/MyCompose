package com.example.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import coil.compose.rememberImagePainter

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetText("This is a bird !")
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun SetText(text: String) {
    Card {
        var isExpanded by remember { mutableStateOf(false) }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()) {
                Column(modifier = Modifier.clickable { isExpanded = !isExpanded },) {
                    val image: Painter = painterResource(id = R.mipmap.ic_twitter_image_foreground)
                    Image(
                        painter = image,
                        contentDescription = "bird image",
                    )
                    AnimatedVisibility(isExpanded) {
                        Text(text = text)
                    }
                }
        }
    }
}