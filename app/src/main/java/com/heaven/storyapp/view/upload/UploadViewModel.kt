package com.heaven.storyapp.view.upload

import androidx.lifecycle.ViewModel
import com.heaven.storyapp.view.data.retrofit.GeneralRepository
import java.io.File

class UploadViewModel(private val repository: GeneralRepository) : ViewModel() {
    fun uploadImage(token:String, file: File, description: String) = repository.uploadImage(token, file, description)
}