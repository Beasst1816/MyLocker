package student

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.VirtualIdData
import datastore.AppPreferenceManager
import kotlinx.coroutines.launch


enum class IdUiMode {
    CREATE,
    VIEW,
    EDIT
}

class StudentIdViewModel(
    private val prefs: AppPreferenceManager
) : ViewModel() {
   var idData: VirtualIdData? = null
       private set

   var uiMode: IdUiMode = IdUiMode.CREATE
       private set


    fun loadId() {
        viewModelScope.launch {
            val storedId = prefs.getVirtualId()
            if (storedId != null) {
                idData = storedId
                uiMode = IdUiMode.VIEW
            } else {
                uiMode = IdUiMode.CREATE
            }
        }
    }


    fun saveId(data: VirtualIdData) {
        viewModelScope.launch {
            prefs.saveVirtualId(data)
            idData = data
            uiMode = IdUiMode.VIEW
        }
    }

    fun startEdit() {
        uiMode = IdUiMode.EDIT
    }

    fun cancelEdit() {
        uiMode = IdUiMode.VIEW
    }
}