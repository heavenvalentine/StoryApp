package com.heaven.storyapp.view.signup

import androidx.lifecycle.ViewModel
import com.heaven.storyapp.view.data.GeneralRepository

class SignUpViewModel (private val repository: GeneralRepository) : ViewModel() {
    fun signUp(name: String, email: String, password: String) = repository.signUp(name, email, password)
}