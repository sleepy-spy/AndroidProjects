package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "authpage"
                ) {
                    composable("votingpage") {
                        VotingPage(onLogout = {
                            Firebase.auth.signOut()
                            navController.navigate("authpage") {
                                popUpTo("votingpage") { inclusive = true }
                            }
                        }, navController)
                    }
                    composable("infopage") {
                        InfoPage(navController)
                    }
                    composable("authpage") {
                        AuthPage(onLoginSuccess = {
                            navController.navigate("votingpage") {
                                popUpTo("authpage") { inclusive = true }
                            }
                        })
                    }
                }
            }
        }
    }
}