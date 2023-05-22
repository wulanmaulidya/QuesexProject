package org.d3ifproject.quesex.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.d3ifproject.quesex.databinding.ActivitySigninBinding

class SigninActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySigninBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}