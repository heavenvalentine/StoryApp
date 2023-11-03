package com.heaven.storyapp.view.map

import androidx.lifecycle.ViewModel
import com.heaven.storyapp.view.data.GeneralRepository

class MapViewModel (private val repository: GeneralRepository) : ViewModel() {
    fun getStoriesWithLocation(token: String) = repository.getStoriesWithLocation(token)
}