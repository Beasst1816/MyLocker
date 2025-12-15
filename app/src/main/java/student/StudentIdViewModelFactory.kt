package student

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import datastore.AppPreferenceManager

class StudentIdViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentIdViewModel::class.java)) {
            return StudentIdViewModel(
                AppPreferenceManager(context)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
