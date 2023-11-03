package com.heaven.storyapp.view.data.di

import android.content.Context
import com.heaven.storyapp.view.data.GeneralRepository
import com.heaven.storyapp.view.data.pref.UserPreference
import com.heaven.storyapp.view.data.pref.dataStore
import com.heaven.storyapp.view.data.retrofit.ApiConfig

object Injection {
    fun provideRepository(context: Context): GeneralRepository {
        val apiService = ApiConfig.getApiService()
        val pref = UserPreference.getInstance(context.dataStore)
        return GeneralRepository.getInstance(apiService,pref)
    }
}