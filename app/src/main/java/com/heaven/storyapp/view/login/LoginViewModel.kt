package com.heaven.storyapp.view.login

import androidx.lifecycle.ViewModel
import com.heaven.storyapp.view.data.UserRepository

class LoginViewModel(private val repository: UserRepository) : ViewModel() {
    fun login(email: String, password: String) = repository.login(email, password)

}