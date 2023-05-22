package org.d3ifproject.quesex.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.d3ifproject.quesex.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}