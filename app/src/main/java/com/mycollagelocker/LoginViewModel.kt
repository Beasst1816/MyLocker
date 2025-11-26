package com.mycollagelocker

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var fullName by mutableStateOf(" ")
    var email by mutableStateOf(" ")
    var password by mutableStateOf(" ")


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

    }
