package com.heaven.storyapp.view.signup

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.google.android.material.textfield.TextInputLayout
import com.heaven.storyapp.R
import com.heaven.storyapp.databinding.ActivitySignupBinding
import com.heaven.storyapp.view.ViewModelFactory
import com.heaven.storyapp.view.data.di.AlertIndicator

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private val signUpViewModel by viewModels<SignUpViewModel> {
        ViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        playAnimation()

        binding.passwordEditText.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int){
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().length >= 8) {
                    binding.passwordEditText.error = null
                    binding.signupButton.isEnabled = true
                    binding.passwordEditTextLayout.endIconMode = TextInputLayout.END_ICON_PASSWORD_TOGGLE
                } else {
                    binding.passwordEditText.error = getString(R.string.msg_error_password)
                    binding.signupButton.isEnabled = false
                    binding.passwordEditTextLayout.endIconMode = TextInputLayout.END_ICON_PASSWORD_TOGGLE
                }
            }

            override fun afterTextChanged(s: Editable) {
                setupAction()
            }
        })
    }

    private fun setupView() {
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
    }

    private fun setupAction() {
        binding.signupButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            signUpViewModel.signUp(name, email, password).observe(this) { result ->
                if (result != null) {
                    when(result) {
                        AlertIndicator.Loading -> {
                            binding.progressBar.isVisible = true
                        }
                        is AlertIndicator.Success -> {
                            binding.progressBar.isVisible = false
                            AlertDialog.Builder(this).apply {
                                setTitle("Yay!")
                                setMessage("The account with the email $email is ready. Let's log in and share your story.")
                                setPositiveButton("Next") { _, _ ->
                                    finish()
                                }
                                create()
                                show()
                            }
                        }
                        is AlertIndicator.Error -> {
                            binding.progressBar.isVisible = false
                            AlertDialog.Builder(this).apply {
                                setTitle("Oops!")
                                setMessage("The account with the email $email is not ready. Let's try again.")
                                setPositiveButton("Ok") { _, _ ->
                                    finish()
                                }
                                create()
                                show()
                            }
                        }
                    }
                }
            }


        }
    }

    private fun playAnimation() {
        ObjectAnimator.ofFloat(binding.imageView, View.TRANSLATION_X, -30f, 30f).apply {
            duration = 6000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()

        val title = ObjectAnimator.ofFloat(binding.titleTextView, View.ALPHA, 1f).setDuration(100)
        val nameTextView =
            ObjectAnimator.ofFloat(binding.nameTextView, View.ALPHA, 1f).setDuration(100)
        val nameEditTextLayout =
            ObjectAnimator.ofFloat(binding.nameEditTextLayout, View.ALPHA, 1f).setDuration(100)
        val emailTextView =
            ObjectAnimator.ofFloat(binding.emailTextView, View.ALPHA, 1f).setDuration(100)
        val emailEditTextLayout =
            ObjectAnimator.ofFloat(binding.emailEditTextLayout, View.ALPHA, 1f).setDuration(100)
        val passwordTextView =
            ObjectAnimator.ofFloat(binding.passwordTextView, View.ALPHA, 1f).setDuration(100)
        val passwordEditTextLayout =
            ObjectAnimator.ofFloat(binding.passwordEditTextLayout, View.ALPHA, 1f).setDuration(100)
        val signup = ObjectAnimator.ofFloat(binding.signupButton, View.ALPHA, 1f).setDuration(100)


        AnimatorSet().apply {
            playSequentially(
                title,
                nameTextView,
                nameEditTextLayout,
                emailTextView,
                emailEditTextLayout,
                passwordTextView,
                passwordEditTextLayout,
                signup
            )
            startDelay = 100
        }.start()
    }
}