package com.example.myapplication



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun InfoPage(navHostController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Box(
            modifier = Modifier
                .padding(top = 40.dp)
                .fillMaxWidth()
        ) {
            Text(
                "This is the Info Page!",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                fontSize = 50.sp,
                lineHeight = 60.sp,
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }
        Text(
            text = "This application is for voting whether or not you want a vending machine in SST.\n\n" +
                    "You can see the votes based on the bar in the voting page.\n\n" +
                    "Once you vote, you will be immediately signed out. If you wish to vote again, you can sign in again to vote.",
            fontSize = 18.sp,
            lineHeight = 23.sp,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 16.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(
                onClick = {
                    navHostController.popBackStack()
                },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 40.dp)
            ) {
                Text(
                    "Go Back!",
                    fontSize = 40.sp,
                    lineHeight = 52.sp,
                    textAlign = TextAlign.Justify
                )
            }
        }
    }


}