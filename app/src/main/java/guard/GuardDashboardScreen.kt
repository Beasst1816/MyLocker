package guard

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