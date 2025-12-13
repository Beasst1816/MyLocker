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
    initialData: VirtualIdData?,
    onSubmit: (VirtualIdData) -> Unit
) {
    var name by remember(initialData) {
        mutableStateOf(initialData?.name ?: "")
    }
    var enrollment by remember(initialData) {
        mutableStateOf(initialData?.enrollment ?: "")
    }
    var cource by remember(initialData) {
        mutableStateOf(initialData?.cource ?: "")
    }
    var college by remember(initialData) {
        mutableStateOf(initialData?.collage ?: "")
    }
    var year by remember(initialData) {
        mutableStateOf(initialData?.admissionYear ?: "")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        TextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
        TextField(value = enrollment, onValueChange = { enrollment = it }, label = { Text("Enrollment") })
        TextField(value = cource, onValueChange = { cource = it }, label = { Text("Course") })
        TextField(value = college, onValueChange = { college = it }, label = { Text("College") })
        TextField(value = year, onValueChange = { year = it }, label = { Text("Year") })

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onSubmit(
                    VirtualIdData(
                        name = name,
                        enrollment = enrollment,
                        cource = cource,
                        collage = college,
                        admissionYear = year
                    )
                )
            }
        ) {
            Text("Generate Virtual ID")
        }
    }
}
