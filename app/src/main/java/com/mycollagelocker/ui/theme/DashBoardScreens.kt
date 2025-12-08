package com.mycollagelocker.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StudentDashboardScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Student Dashboard", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(24.dp))

        Button(onClick = { /* todo */ } ) { Text("View Documents") }
        Button(onClick = { /* todo */ } ) { Text("Upload Documents") }
        Button(onClick = { /* todo */ } ) { Text("Genrate QR") }
        Button(onClick = { /* todo */ } ) { Text("Logout") }
    }
}

@Composable
fun GuardDashboardScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Guard Dashboard", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(24.dp))

        Button( onClick = { /* todo */ } ) { Text("Scan QR") }
        Button( onClick = { /* todo */ } ) { Text("View Student") }
        Button( onClick = { /* todo */ } ) { Text("Logout") }

    }
}



@Preview
@Composable
fun StudentDashboardScreenPreview() {
    StudentDashboardScreen()
}

@Preview
@Composable
fun GuardDashboardScreenPreview() {
    GuardDashboardScreen()
}