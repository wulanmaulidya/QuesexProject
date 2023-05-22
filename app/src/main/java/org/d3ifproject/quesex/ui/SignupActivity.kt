package org.d3ifproject.quesex.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.d3ifproject.quesex.MainActivity
import org.d3ifproject.quesex.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, SigninActivity::class.java)
            startActivity(intent)
            this.finish()
        }
        binding.buttonSignIn.setOnClickListener {
            val intent = Intent(this, SigninActivity::class.java)
            startActivity(intent)
            this.finish()
        }
    }

        override fun onBackPressed() {
            // jangan diapa2in / diisi.
        }
    }
