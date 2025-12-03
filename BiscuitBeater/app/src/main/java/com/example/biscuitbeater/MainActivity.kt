package com.example.biscuitbeater

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
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
                var count by remember { mutableStateOf(0) }
                var additionUpgrade by remember { mutableStateOf(0) }
                var multiplierUpgrade by remember { mutableStateOf(1) }
                var hardmode by remember { mutableStateOf(false) }
                Scaffold { contentPadding ->
                    Column(modifier = Modifier.padding(contentPadding)) {
                        val navController = rememberNavController()
                        NavHost(
                            navController = navController,
                            startDestination = "HomePage"
                        ) {
                            composable(route = "HomePage") {
                                biscuitBeater(
                                    nav = navController,
                                    count = count,
                                    additionUpgrade = additionUpgrade,
                                    multiplierUpgrade = multiplierUpgrade,
                                    onCountChange = { newCount -> count = newCount },
                                    hardmode = hardmode
                                )
                            }
                            composable(route = "Upgrades") {
                                upgradesPage(
                                    nav = navController,
                                    count = count,
                                    onCountChange = { newCount -> count = newCount },
                                    additionUpgrade = additionUpgrade,
                                    onAdditionChange = { newAddition ->
                                        additionUpgrade = newAddition
                                    },
                                    multiplierUpgrade = multiplierUpgrade,
                                    onMultiplierChange = { newMultiplier ->
                                        multiplierUpgrade = newMultiplier
                                    }
                                )
                            }
                            composable(route = "Settings") {
                                settingsPage(
                                    nav = navController,
                                    hardmode = {hardmodechange -> hardmode = hardmodechange},
                                    hardmodestate = hardmode
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}






