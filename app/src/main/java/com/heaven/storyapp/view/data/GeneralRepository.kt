package com.heaven.storyapp.view.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.google.gson.Gson
import com.heaven.storyapp.view.data.di.AlertIndicator
import com.heaven.storyapp.view.data.pref.UserModel
import com.heaven.storyapp.view.data.pref.UserPreference
import com.heaven.storyapp.view.data.retrofit.ApiService
import com.heaven.storyapp.view.data.retrofit.response.DetailStoryResponse
import com.heaven.storyapp.view.data.retrofit.response.FileUploadResponse
import com.heaven.storyapp.view.data.retrofit.response.ListStoryItem
import com.heaven.storyapp.view.data.retrofit.response.LoginResponse
import com.heaven.storyapp.view.data.retrofit.response.SignUpResponse
import com.heaven.storyapp.view.data.retrofit.response.StoryResponse
import kotlinx.coroutines.flow.Flow
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.HttpException
import java.io.File

class GeneralRepository private constructor(
    private val apiService: ApiService,
    private val userPreference: UserPreference
) {

    private suspend fun saveSession(user: UserModel) {
        userPreference.saveSession(user)
    }

    fun getSession(): Flow<UserModel> {
        return userPreference.getSession()
    }

    suspend fun logout() {
        userPreference.logout()
    }

    fun login(email: String, password: String) : LiveData<AlertIndicator<LoginResponse>> = liveData {
        emit(AlertIndicator.Loading)
        try {
            val response = apiService.login(email, password)
            if (response.error){
                emit(AlertIndicator.Error(response.message))
            }
            else {
                emit(AlertIndicator.Success(response))
                saveSession(UserModel(email, response.loginResult.token, true))
            }
        } catch (e:Exception){
            emit(AlertIndicator.Error(e.message.toString()))
        }
    }

    fun signUp(name: String, email: String, password: String): LiveData<AlertIndicator<SignUpResponse>> = liveData {
        emit(AlertIndicator.Loading)
        try {
            val response = apiService.register(name, email, password)
            if (response.error){
                emit(AlertIndicator.Error(response.message))
            }
            else {
                emit(AlertIndicator.Success(response))
            }
        } catch (e:Exception){
            emit(AlertIndicator.Error(e.message.toString()))
        }
    }

    fun getStories(token: String): LiveData<AlertIndicator<StoryResponse>> = liveData{
        emit(AlertIndicator.Loading)
        try {
            val response = apiService.getStories("Bearer $token")
            if (response.error){
                emit(AlertIndicator.Error(response.message))
            }
            else {
                emit(AlertIndicator.Success(response))
            }
        } catch (e:Exception){
            emit(AlertIndicator.Error(e.message.toString()))
        }
    }

    fun getDetailStory(id: String, token: String): LiveData<AlertIndicator<DetailStoryResponse>> = liveData{
        emit(AlertIndicator.Loading)
        try {
            val response = apiService.getDetailStory(id,"Bearer $token")
            if (response.error){
                emit(AlertIndicator.Error(response.message))
            }
            else {
                emit(AlertIndicator.Success(response))
            }
        } catch (e:Exception){
            emit(AlertIndicator.Error(e.message.toString()))
        }
    }

    fun getStoriesWithLocation(token: String): LiveData<AlertIndicator<StoryResponse>> = liveData{
        emit(AlertIndicator.Loading)
        try {
            val response = apiService.getStoriesWithLocation("Bearer $token")
            if (response.error){
                emit(AlertIndicator.Error(response.message))
            }
            else {
                emit(AlertIndicator.Success(response))
            }
        } catch (e:Exception){
            emit(AlertIndicator.Error(e.message.toString()))
        }
    }

    fun uploadImage(token: String, imageFile: File, description: String) : LiveData<AlertIndicator<FileUploadResponse>> = liveData{
        emit(AlertIndicator.Loading)
        val requestBody = description.toRequestBody("text/plain".toMediaType())
        val requestImageFile = imageFile.asRequestBody("image/jpeg".toMediaType())
        val multipartBody = MultipartBody.Part.createFormData(
            "photo",
            imageFile.name,
            requestImageFile
        )
        try {
            val successResponse = apiService.uploadImage("Bearer $token", multipartBody, requestBody)
            emit(AlertIndicator.Success(successResponse))
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, FileUploadResponse::class.java)
            emit(AlertIndicator.Error(errorResponse.message))
        }
    }

    fun getStoryPaging(token: String): LiveData<PagingData<ListStoryItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20
            ),
            pagingSourceFactory = {
                StoryPagingSource(apiService, token)
            }
        ).liveData
    }


    companion object {
        @Volatile
        private var instance: GeneralRepository? = null
        fun getInstance(
            apiService: ApiService,
            userPreference: UserPreference
        ): GeneralRepository =
            instance ?: synchronized(this) {
                instance ?: GeneralRepository(apiService, userPreference)
            }.also { instance = it }
    }
}