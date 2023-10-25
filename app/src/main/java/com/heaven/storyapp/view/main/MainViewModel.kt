package com.heaven.storyapp.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.heaven.storyapp.view.data.retrofit.GeneralRepository
import com.heaven.storyapp.view.data.pref.UserModel
import kotlinx.coroutines.launch

class MainViewModel(private val repository: GeneralRepository) : ViewModel() {

    fun getStories(token: String) = repository.getStories(token)

    fun getSession(): LiveData<UserModel> {
        return repository.getSession().asLiveData()
    }

    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }

}