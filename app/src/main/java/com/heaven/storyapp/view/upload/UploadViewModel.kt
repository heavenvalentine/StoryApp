package com.heaven.storyapp.view.upload

import androidx.lifecycle.ViewModel
import com.heaven.storyapp.view.data.retrofit.GeneralRepository
import java.io.File

class UploadViewModel(private val repository: GeneralRepository) : ViewModel() {
    fun uploadImage(file: File, description: String) = repository.uploadImage(file, description)
}