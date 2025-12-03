package com.example.kotlinlesson3


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.FilledIconButton as FilledIconButton1


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme { // Added theme wrapper
                App()
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPreview() {
    MaterialTheme {
        App()
    }
}


@Composable
fun App() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        var number by remember { mutableIntStateOf(1) }
        var multiplier by remember { mutableIntStateOf(1)}
        OutlinedButton(onClick = {
            number = number + 1
        }) {
            Text("Click here for free cookie")
        }

        OutlinedButton(onClick = {
            multiplier = multiplier * 2
        }) {
            Text("Click here for even MORE cookies")
        }
        var finalNumber by remember {mutableIntStateOf(number * multiplier)}
        Text("Multiplier: x$multiplier")
        Text("You have $finalNumber cookies")
    }
}


