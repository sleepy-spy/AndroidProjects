package com.example.biscuitbeater

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun upgradesPage(
    nav: NavHostController,
    count: Int,
    onCountChange: (Int) -> Unit,
    additionUpgrade: Int,
    onAdditionChange: (Int) -> Unit,
    multiplierUpgrade: Int,
    onMultiplierChange: (Int) -> Unit
) {
    var multiplierQuant by remember { mutableStateOf(0) }
    var additionQuant by remember { mutableStateOf(0) }
    var cost by remember { mutableStateOf(0) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
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
                    if (additionQuant > 0) {
                        additionQuant -= 1
                    } else {
                        additionQuant = 0
                    }
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
                    if (multiplierQuant > 0) {
                        multiplierQuant -= 1
                    } else {
                        multiplierQuant = 0
                    }
                }) {
                    Text("-")
                }

            }
        }
        cost = additionQuant * 100 + multiplierQuant * 500
        Text(
            text = "$cost",
            fontSize = 100.sp
        )
        Text(
            text = "You have $count monies",
            fontSize = 40.sp
        )
        Button(
            onClick = {
                if (count >= cost) {
                    val newCount = count - cost
                    onCountChange(newCount)
                    val newAddition = additionUpgrade + additionQuant
                    onAdditionChange(newAddition)
                    val newMultiplier = multiplierUpgrade + multiplierQuant
                    onMultiplierChange(newMultiplier)
                    multiplierQuant = 0
                    additionQuant = 0
                    cost = 0
                }
            },
            modifier = Modifier.size(width = 200.dp, height = 50.dp)
        ) {
            Text(text = "Buy Upgrades")
        }
        Button(
            onClick = {
                nav.navigate("HomePage")
            },
            modifier = Modifier.size(width = 200.dp, height = 50.dp)
        ) {
            Text("Return to Home Page")
        }


    }


}