package com.heaven.storyapp.view.data.pref

data class UserModel(
    val email: String,
    val token: String,
    val isLogin: Boolean = false
)