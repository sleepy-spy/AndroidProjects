package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RealTheme {  // Using your custom RealTheme
                App()
            }
        }
    }
}

@Composable
fun RealTheme(content: @Composable () -> Unit) {
    // You can customize your theme here. For simplicity, let's use the default theme.
    MyApplicationTheme {  // You can also add custom styles here if needed
        content()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun App() {
    Column{
        Text("TO-DO LIST", fontWeight = FontWeight.Bold)
        Text("1. clean", color = Color.Red, modifier = Modifier.size(30.dp)
        Text("2. wash")
        Text("3. Oil up")
        Text("4. Say hi")
        Text("Scream")
    }
}
