package com.mycollagelocker.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StudentDashboardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Student Dashboard", fontSize = 28.sp)
        Spacer(Modifier.height(24.dp))
        Text("Welcome student. Your features will be here.")
    }
}

@Composable
fun GuardDashboardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Guard Dashboard", fontSize = 28.sp)
        Spacer(Modifier.height(24.dp))
        Text("Welcome guard. Your controls will be here.")
    }
}

