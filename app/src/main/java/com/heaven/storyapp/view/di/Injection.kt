package com.heaven.storyapp.view.di

import android.content.Context
import com.heaven.storyapp.view.data.UserRepository
import com.heaven.storyapp.view.data.pref.UserPreference
import com.heaven.storyapp.view.data.pref.dataStore
import com.heaven.storyapp.view.data.retrofit.ApiConfig

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val apiService = ApiConfig.getApiService()
        val pref = UserPreference.getInstance(context.dataStore)
        return UserRepository.getInstance(apiService,pref)
    }
}