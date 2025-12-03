package com.example.biscuitbeater

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlin.math.max

@Composable
fun biscuitBeater(
    nav: NavHostController,
    count: Int,
    onCountChange: (Int) -> Unit,
    additionUpgrade: Int,
    multiplierUpgrade: Int,
    hardmode: Boolean
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Hard Mode Status: $hardmode")
        Text("Addition Upgrades: $additionUpgrade")
        Text("Multiplier Upgrades: $multiplierUpgrade")
        Image(
            painter = painterResource(id = R.drawable.cookie),
            contentDescription = null,
            modifier = Modifier
                .size(400.dp) // Fixed size
                .clickable {
                    if (hardmode == true) {
                        onCountChange(max((count + 1), (count + ((1 + additionUpgrade) * multiplierUpgrade))/2))
                    } else {
                        onCountChange(count + ((1 + additionUpgrade) * multiplierUpgrade))
                    } }
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
                onClick = { onCountChange(0) },
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
                    nav.navigate("Upgrades")
                },
                modifier = Modifier.size(width = 200.dp, height = 50.dp)
            ) {
                Text("Upgrades Page")
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    nav.navigate("Settings")
                },
                modifier = Modifier.size(width = 200.dp, height = 50.dp)
            ) {
                Text("Settings Page")
            }
        }
    }
}