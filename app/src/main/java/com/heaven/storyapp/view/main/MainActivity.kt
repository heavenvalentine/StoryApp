package com.heaven.storyapp.view.main

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.heaven.storyapp.databinding.ActivityMainBinding
import com.heaven.storyapp.view.ViewModelFactory
import com.heaven.storyapp.view.adapter.StoryAdapter
import com.heaven.storyapp.view.data.di.AlertIndicator
import com.heaven.storyapp.view.story.response.ListStoryItem
import com.heaven.storyapp.view.upload.UploadActivity
import com.heaven.storyapp.view.welcome.WelcomeActivity

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel> {
        ViewModelFactory.getInstance(this)
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getSession().observe(this) { user ->
            if (!user.isLogin) {
                startActivity(Intent(this, WelcomeActivity::class.java))
                finish()
            } else {
                setupView(user.token)
            }
        }

        setupAction()
    }

    private fun setupView(token: String) {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()

        viewModel.getStories(token).observe(this){ alert ->
            if (alert != null){
                when(alert) {
                    AlertIndicator.Loading -> {
                        binding.progressBar.isVisible = true
                    }
                    is AlertIndicator.Error -> {
                        binding.progressBar.isVisible = false
                        Toast.makeText(this, alert.error, Toast.LENGTH_SHORT).show()
                    }
                    is AlertIndicator.Success -> {
                        binding.progressBar.isVisible = false
                        binding.rvStories.layoutManager = LinearLayoutManager(this)
                        binding.rvStories.adapter = triggerRecyclerView(alert.data.listStory,token)
                    }
                }
            }
        }
    }

    private fun triggerRecyclerView(list: List<ListStoryItem>, token: String) : StoryAdapter = StoryAdapter(list, token)


    private fun setupAction() {
        binding.logoutButton.setOnClickListener {
            viewModel.logout()
        }

        binding.addStory.setOnClickListener {
            val intent = Intent(this, UploadActivity::class.java)
            startActivity(intent)
        }
    }
}