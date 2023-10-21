package com.heaven.storyapp.view.di

import android.content.Context
import com.heaven.storyapp.view.data.pref.UserRepository
import com.heaven.storyapp.view.data.pref.UserPreference
import com.heaven.storyapp.view.data.pref.dataStore

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        return UserRepository.getInstance(pref)
    }
}