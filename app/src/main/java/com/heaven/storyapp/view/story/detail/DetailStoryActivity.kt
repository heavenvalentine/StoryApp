package com.heaven.storyapp.view.story.detail

import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.heaven.storyapp.R
import com.heaven.storyapp.databinding.ActivityDetailBinding
import com.heaven.storyapp.view.ViewModelFactory
import com.heaven.storyapp.view.data.AlertIndicator

class DetailStoryActivity: AppCompatActivity() {

    private val detailStoryViewModel by viewModels<DetailStoryViewModel> {
        ViewModelFactory.getInstance(this)
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra(EXTRA_ID)
        val token = intent.getStringExtra(EXTRA_TOKEN)

        if (token != null && id != null) {
            setupView(id, token)
        }

    }

    private fun setupView(id: String, token: String) {
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

        detailStoryViewModel.getDetailStory(id, token).observe(this){ alert ->
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
                        binding.apply {
                            progressBar.isVisible = false
                            tvDetailName.text = alert.data.story.name
                            tvDetailDescription.text = alert.data.story.description

                            Glide.with(this@DetailStoryActivity)
                                .load(alert.data.story.photoUrl)
                                .error(R.drawable.image_dicoding)
                                .into(ivStoryPhoto)
                        }
                    }
                }
            }
        }
    }

    companion object {
        const val EXTRA_ID: String = "extra_id"
        const val EXTRA_TOKEN: String = "extra_token"
    }
}