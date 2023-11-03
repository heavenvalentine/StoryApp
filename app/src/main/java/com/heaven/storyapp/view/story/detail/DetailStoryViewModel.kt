package com.heaven.storyapp.view.story.detail

import androidx.lifecycle.ViewModel
import com.heaven.storyapp.view.data.GeneralRepository

class DetailStoryViewModel (private val repository: GeneralRepository) : ViewModel() {

    fun getDetailStory(id: String, token: String) = repository.getDetailStory(id, token)
}

