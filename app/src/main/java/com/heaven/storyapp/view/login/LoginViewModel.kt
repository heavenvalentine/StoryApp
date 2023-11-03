package com.heaven.storyapp.view.login

import androidx.lifecycle.ViewModel
import com.heaven.storyapp.view.data.GeneralRepository

class LoginViewModel(private val repository: GeneralRepository) : ViewModel() {
    fun login(email: String, password: String) = repository.login(email, password)

}