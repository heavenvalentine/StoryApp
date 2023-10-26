package com.heaven.storyapp.view.custom

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Patterns
import androidx.appcompat.widget.AppCompatEditText
import com.heaven.storyapp.R

class PasswordEditText: AppCompatEditText {
        constructor(context: Context) : super(context) {
            init()
        }

        constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
            init()
        }

        constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
            init()
        }

        private fun init() {
            addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    val passwordError = if (s.toString().length < 8) context.getString(R.string.msg_error_password) else null
                    val emailError = if (id == R.id.emailEditText && !isValidEmail(s.toString())) context.getString(R.string.msg_error_email) else null

                    error = when {
                        passwordError != null -> passwordError
                        emailError != null -> emailError
                        else -> null
                    }
                }

                override fun afterTextChanged(s: Editable) {
                }
            })
        }

    private fun isValidEmail(email: String): Boolean {
        val pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }
}
