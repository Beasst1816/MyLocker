package com.mycollagelocker

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class  LoginViewModel : ViewModel() {
    var fullName by mutableStateOf("")
        private set
    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set

    val role: String = "guard"



    fun validateInput(): Boolean {
        return fullName.isNotBlank() &&
                email.isNotBlank() &&
                email.contains("@") &&
                email.contains(".") &&
                password.isNotBlank()
    }


    fun login() : Boolean {
        if (validateInput()) {
            return true
        }else {
            return false

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

    }
