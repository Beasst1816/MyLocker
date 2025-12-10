package student

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import data.VirtualIdData

data class VirtualIdData(
    val name: String = "",
    val enrollment: String = "",
    val Cource: String = "",
    val admissionYear: String = "",
    val college: String = ""
)

class StudentIdViewModel : ViewModel() {
    var idData by mutableStateOf(VirtualIdData())
        private set

    fun saveId(data: VirtualIdData) {
        idData = data
    }
}