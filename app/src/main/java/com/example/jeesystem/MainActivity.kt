package com.example.jeesystem

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jeesystem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example click (prevents unused warning + good test)
        binding.btnMath.setOnClickListener {
            // TODO: Start QuizActivity later
        }
    }
}
