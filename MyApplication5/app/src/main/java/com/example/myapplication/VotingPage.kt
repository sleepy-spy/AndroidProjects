package com.example.myapplication

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.Firebase
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.firestore

@Composable
fun VoteBar(yesVotes: Long, noVotes: Long, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .width(350.dp)
            .height(40.dp)
            .clip(RoundedCornerShape(12.dp))
    ) {
        val totalVotes = yesVotes.toFloat() + noVotes.toFloat()
        val yesRatio = if (totalVotes == 0f) 0.5f else yesVotes.toFloat() / totalVotes
        val noRatio = if (totalVotes == 0f) 0.5f else noVotes.toFloat() / totalVotes
        if (yesRatio != 0f) {
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(yesRatio)
                    .background(if (totalVotes == 0f) Color.Gray else Color.Green)
            ) {
                Row {
                    Spacer(modifier = Modifier.width(20.dp))
                    if (yesVotes == 1L) {
                        Text("Yes ($yesVotes Vote")
                    } else {
                        Text("Yes ($yesVotes Votes)")
                    }
                }
            }
        }
        if (noRatio != 0f) {
            Box(
                contentAlignment = Alignment.CenterEnd,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(noRatio)
                    .background(if (totalVotes == 0f) Color.Gray else Color.Red)
            ) {
                Row {
                    if (noVotes == 1L) {
                        Text("No ($noVotes Vote)")
                    } else {
                        Text("No ($noVotes Votes")
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                }
            }
        }
    }
}

@Composable
fun VotingPage(onLogout: () -> Unit, navHostController: NavHostController) {
    val context = LocalContext.current
    val db = Firebase.firestore
    val docRef = db.collection("Votes").document("Votes")
    var yesVotes by remember { mutableLongStateOf(0) }
    var noVotes by remember { mutableLongStateOf(0) }
    androidx.compose.runtime.DisposableEffect(Unit) {
        val listenerRegistration = docRef.addSnapshotListener { snapshot, error ->
            if (error != null) {
                Toast.makeText(context, "Snapshot error: ${error.message}", Toast.LENGTH_LONG).show()
                return@addSnapshotListener
            }
            if (snapshot != null && snapshot.exists()) {
                yesVotes = snapshot.getLong("yes") ?: 0L
                noVotes = snapshot.getLong("no") ?: 0L
            }
        }
        onDispose {
            listenerRegistration.remove()
        }
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 200.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            VoteBar(yesVotes = yesVotes, noVotes = noVotes)
            Spacer(modifier = Modifier.height(100.dp))
            Text(
                text = "Vote for Vending Machines in SST",
                fontSize = 50.sp,
                lineHeight = 60.sp,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(50.dp))
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        db.collection("Votes").document("Votes").update("yes", FieldValue.increment(1))
                            .addOnSuccessListener {
                                Toast.makeText(context, "Vote recorded!", Toast.LENGTH_LONG).show()
                                onLogout()
                            }
                            .addOnFailureListener {
                                Toast.makeText(context, "Failed to vote", Toast.LENGTH_LONG).show()
                            }
                    }
                ) {
                    Text(
                        "Yes",
                        fontSize = 40.sp
                    )
                }
                Spacer(modifier = Modifier.width(25.dp))
                Button(
                    onClick = {
                        db.collection("Votes").document("Votes").update("no", FieldValue.increment(1))
                            .addOnSuccessListener {
                                Toast.makeText(context, "Vote recorded!", Toast.LENGTH_LONG).show()
                                onLogout()
                            }
                            .addOnFailureListener {
                                Toast.makeText(context, "Failed to vote: ${it.message}", Toast.LENGTH_LONG).show()
                            }
                    }
                ) {
                    Text(
                        "No",
                        fontSize = 40.sp
                    )
                }
            }
        }
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    navHostController.navigate("infopage")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,         // Background color
                    contentColor = Color.White           // Text/icon color
                ),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(40.dp)
            ) {
                Text(
                    "Info Page",
                    fontSize = 40.sp
                )
            }
        }
    }
}





