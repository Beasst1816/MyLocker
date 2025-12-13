package student

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import data.VirtualIdData


enum class IdUiMode {
    CREATE,
    VIEW,
    EDIT
}

class StudentIdViewModel : ViewModel() {
    var idData by mutableStateOf<VirtualIdData?>(null)
        private set

    var uiMode by mutableStateOf(IdUiMode.CREATE)
        private set

    fun saveId(data: VirtualIdData) {
        idData = data
        uiMode = IdUiMode.VIEW
    }

    fun startEdit() {
        uiMode = IdUiMode.EDIT
    }

    fun cancelEdit() {
        uiMode = IdUiMode.VIEW
    }
}