package student

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import navigation.Routes

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

        Button(onClick = {
            navController.navigate(Routes.CREATE_VIRTUAL_ID)
        }) {
            Text("Virtual ID Card")
        }
    }
}