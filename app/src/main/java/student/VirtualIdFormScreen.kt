package student

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.VirtualIdData


@Composable
fun CreateIdScreen(
    onSubmit: (VirtualIdData) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var enrollment by remember { mutableStateOf("") }
    var cource by remember { mutableStateOf("") }
    var collegeName by remember { mutableStateOf("") }
    var admissionYear by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            value =  name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = enrollment,
            onValueChange =  { enrollment = it },
            label = { Text("Enrollment Number") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = cource,
            onValueChange = { cource = it },
            label =  { Text("Cource") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = collegeName,
            onValueChange = { collegeName = it },
            label = { Text("College Name") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = admissionYear,
            onValueChange = { admissionYear = it },
            label = { Text("Admission Year") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                if (
                    name.isNotBlank() &&
                    enrollment.isNotBlank() &&
                    cource.isNotBlank() &&
                    collegeName.isNotBlank() &&
                    admissionYear.isNotBlank()
                ) {
                    onSubmit(
                        VirtualIdData(
                            name = name,
                            enrollment = enrollment,
                            cource = cource,
                            collage = collegeName,
                            admissionYear = admissionYear
                        )
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Genrate Virtual ID")
        }
    }
}





