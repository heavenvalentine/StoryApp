package com.heaven.storyapp.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.heaven.storyapp.view.data.GeneralRepository
import com.heaven.storyapp.view.data.pref.UserModel
import com.heaven.storyapp.view.data.retrofit.response.ListStoryItem
import kotlinx.coroutines.launch

class MainViewModel(private val repository: GeneralRepository) : ViewModel() {

    fun getStories(token: String) = repository.getStories(token)

    fun getSession(): LiveData<UserModel> {
        return repository.getSession().asLiveData()
    }

    fun getPagedStories(token: String): LiveData<PagingData<ListStoryItem>> = repository.getStoryPaging(token).cachedIn(viewModelScope)

    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }

}