package com.example.biscuitbeater

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.biscuitbeater.ui.theme.BiscuitBeaterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BiscuitBeaterTheme {
                Scaffold(

                ) { contentPadding ->
                    Column(
                        modifier = Modifier.padding(contentPadding)
                    ) {
                        val navController = rememberNavController()
                        NavHost(
                            navController = navController,
                            startDestination = "Home Page",
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            composable(route = "Home Page") {
                                biscuitBeater(navController)
                            }
                            composable(route = "Upgrades") {
                                upgradesPage(navController)
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun biscuitBeater(navHostController: NavHostController) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            var count by remember { mutableStateOf(0) }
            Image(
                painter = painterResource(id = R.drawable.cookie),
                contentDescription = null,
                modifier = Modifier
                    .size(400.dp) // Fixed size
                    .clickable { count += 1 }
            )
            Text(
                text = "$count",
                fontSize = 100.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { count = 0 },
                    modifier = Modifier.size(width = 200.dp, height = 50.dp)
                ) {
                    Text(text = "Reset")
                }
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        navHostController.navigate("Upgrades")
                    },
                    modifier = Modifier.size(width = 200.dp, height = 50.dp)
                ) {
                    Text("Upgrades Page")
                }
            }



        }
    }

    @Composable
    fun upgradesPage(navHostController: NavHostController) {
        var multiplierQuant by remember { mutableStateOf(0) }
        var additionQuant by remember {mutableStateOf(0)}
        var factorialQuant by remember { mutableStateOf(0)}
        var cost by remember {mutableStateOf(0)}
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Upgrades",
                    fontSize = 50.sp
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Extra Cookie (100 Cookies)",
                    fontSize = 17.sp
                )
                Row(
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(onClick =
                    {
                        additionQuant += 1
                    }) {
                        Text("+")
                    }
                    Button(onClick = {}) {
                        Text(text = "$additionQuant")
                    }
                    Button(onClick =
                    {
                        additionQuant -= 1
                    }) {
                        Text("-")
                    }

                }

            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Multipliers (500 Cookies)",
                    fontSize = 17.sp
                )
                Row(
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(onClick =
                    {
                        multiplierQuant += 1
                    }) {
                        Text("+")
                    }
                    Button(onClick = {}) {
                        Text(text = "$multiplierQuant")
                    }
                    Button(onClick =
                    {
                        multiplierQuant -= 1
                    }) {
                        Text("-")
                    }

                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Factorial \nMultipliers",
                    fontSize = 17.sp
                )
                Text(
                    text = "(2000 Cookies)"
                )
                Row(
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(onClick =
                    {
                        factorialQuant += 1
                    }) {
                        Text("+")
                    }
                    Button(onClick = {}) {
                        Text(text = "$factorialQuant")
                    }
                    Button(onClick =
                    {
                        factorialQuant -= 1
                    }) {
                        Text("-")
                    }

                }
            }
            Button(
                onClick = {}
            ) {
                Text(text = "Buy Upgrades")
            }


        }


    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        BiscuitBeaterTheme {
            Scaffold(

            ) { contentPadding ->
                Column(
                    modifier = Modifier.padding(contentPadding)
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "Upgrades",
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        composable(route = "Home Page") {
                            biscuitBeater(navController)
                        }
                        composable(route = "Upgrades") {
                            upgradesPage(navController)
                        }
                    }
                }
            }
        }
    }
}