package com.example.kotlinlesson52

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.kotlinlesson52.ui.theme.KotlinLesson52Theme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinLesson52Theme {
                Shopping()
            }
        }
    }
}

@Composable
fun Shopping() {
    var laptopQuant by remember { mutableStateOf(0) }
    var smartphoneQuant by remember { mutableStateOf(0) }
    var headphonesQuant by remember { mutableStateOf(0) }
    var keyboardQuant by remember { mutableStateOf(0) }
    var mouseQuant by remember { mutableStateOf(0) }
    var total by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxHeight()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Laptop",
                fontSize = 30.sp
            )
            Row(
                horizontalArrangement = Arrangement.End
            ) {
                Button(onClick =
                {
                    laptopQuant += 1
                }) {
                    Text("+")
                }
                Button(onClick = {}) {
                    Text(text = "$laptopQuant")
                }
                Button(onClick =
                {
                    laptopQuant -= 1
                }) {
                    Text("-")
                }

            }

        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Smartphone",
                fontSize = 30.sp
            )
            Row(
                horizontalArrangement = Arrangement.End
            ) {
                Button(onClick =
                {
                    smartphoneQuant += 1
                }) {
                    Text("+")
                }
                Button(onClick = {}) {
                    Text(text = "$smartphoneQuant")
                }
                Button(onClick =
                {
                    smartphoneQuant -= 1
                }) {
                    Text("-")
                }

            }

        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Headphones",
                fontSize = 30.sp
            )
            Row(
                horizontalArrangement = Arrangement.End
            ) {
                Button(onClick =
                {
                    headphonesQuant += 1
                }) {
                    Text("+")
                }
                Button(onClick = {}) {
                    Text(text = "$headphonesQuant")
                }
                Button(onClick =
                {
                    headphonesQuant -= 1
                }) {
                    Text("-")
                }

            }

        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Keyboard",
                fontSize = 30.sp
            )
            Row(
                horizontalArrangement = Arrangement.End
            ) {
                Button(onClick =
                {
                    keyboardQuant += 1
                }) {
                    Text("+")
                }
                Button(onClick = {}) {
                    Text(text = "$keyboardQuant")
                }
                Button(onClick =
                {
                    keyboardQuant -= 1
                }) {
                    Text("-")
                }

            }

        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Mouse",
                fontSize = 30.sp
            )
            Row(
                horizontalArrangement = Arrangement.End
            ) {
                Button(onClick =
                {
                    mouseQuant += 1
                }) {
                    Text("+")
                }
                Button(onClick = {}) {
                    Text(text = "$mouseQuant")
                }
                Button(onClick =
                {
                    mouseQuant -= 1
                }) {
                    Text("-")
                }
            }

        }
        total = (laptopQuant * 699 + smartphoneQuant * 499 + headphonesQuant * 299 + keyboardQuant * 199 + mouseQuant * 69) * (109/100)
        Text(
            text = "Your total is $$total",
            fontSize = 30.sp
        )

    }


}




@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
fun ShoppingPreview() {
    KotlinLesson52Theme {
        Shopping()
    }
}