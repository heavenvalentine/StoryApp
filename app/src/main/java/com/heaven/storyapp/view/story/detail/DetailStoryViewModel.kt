package com.heaven.storyapp.view.story.detail

import androidx.lifecycle.ViewModel
import com.heaven.storyapp.view.data.UserRepository

class DetailStoryViewModel (private val repository: UserRepository) : ViewModel() {

    fun getDetailStory(id: String, token: String) = repository.getDetailStory(id, token)
}

