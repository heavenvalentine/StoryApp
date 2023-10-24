package com.heaven.storyapp.view.custom

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.heaven.storyapp.R

class EditText: AppCompatEditText {
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
                    if(s.toString().length < 8) {
                        error = context.getString(R.string.msg_error_password)
                    }
                    else {
                        error = null
                    }
                }

                override fun afterTextChanged(s: Editable) {
                }
            })
        }
}
