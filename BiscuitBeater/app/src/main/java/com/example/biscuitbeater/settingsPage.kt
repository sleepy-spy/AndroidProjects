package com.example.biscuitbeater

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun settingsPage(nav: NavHostController, hardmode: (Boolean) -> Unit, hardmodestate: Boolean) {
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = "Hard Mode Death Switch",
                fontSize = 30.sp
            )
            Switch(
                checked = hardmodestate,
                onCheckedChange = { hardmode(it) }
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { nav.navigate("HomePage") },
                modifier = Modifier.size(width = 200.dp, height = 50.dp)
            ) {
                Text("Return to Home Page")
            }
        }
    }
}

