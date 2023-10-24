package com.heaven.storyapp.view.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.heaven.storyapp.view.data.pref.UserModel
import com.heaven.storyapp.view.data.pref.UserPreference
import com.heaven.storyapp.view.data.retrofit.ApiService
import com.heaven.storyapp.view.login.LoginResponse
import com.heaven.storyapp.view.signup.SignUpResponse
import com.heaven.storyapp.view.story.response.DetailStoryResponse
import com.heaven.storyapp.view.story.response.StoryResponse
import kotlinx.coroutines.flow.Flow

class UserRepository private constructor(
    private val apiService: ApiService,
    private val userPreference: UserPreference
) {

    suspend fun saveSession(user: UserModel) {
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

    companion object {
        @Volatile
        private var instance: UserRepository? = null
        fun getInstance(
            apiService: ApiService,
            userPreference: UserPreference
        ): UserRepository =
            instance ?: synchronized(this) {
                instance ?: UserRepository(apiService, userPreference)
            }.also { instance = it }
    }
}