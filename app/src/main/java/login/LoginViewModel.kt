package login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import datastore.AppPreferenceManager
import kotlinx.coroutines.launch

class  LoginViewModel(
    private val prefs: AppPreferenceManager
) : ViewModel() {
    var fullName by mutableStateOf("")
        private set
    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set

    var selectedRole by mutableStateOf("student")
        private set



    fun validateInput(): Boolean {
        return fullName.isNotBlank() &&
                email.isNotBlank() &&
                email.contains("@") &&
                email.contains(".") &&
                password.isNotBlank()
    }


//    fun login(role: String, onSuccess: () -> Unit) {
//        viewModelScope.launch {
//            prefs.saveLogin(role)
//            onSuccess()
//        }
//    }

    fun login(): Boolean {
        return fullName.isNotBlank() &&
                email.isNotBlank() &&
                password.isNotBlank() &&
                selectedRole.isNotBlank()
    }


    fun saveLogin() {
        viewModelScope.launch {
            prefs.saveLogin(selectedRole)
        }
    }

    fun onFullNameChange(newValue: String) {
        fullName  = newValue
    }
    fun onEmailChange(newValue: String) {
        email = newValue
    }
    fun onPasswordChange(newValue: String) {
        password = newValue
    }
    fun updateRole(role: String) {
        selectedRole = role
    }

    }