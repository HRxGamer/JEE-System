package com.example.jeesystem

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMath = findViewById<Button>(R.id.btnMath)

        btnMath.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }
    }
}
