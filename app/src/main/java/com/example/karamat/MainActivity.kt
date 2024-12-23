package com.example.karamat

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val signup = findViewById<MaterialButton>(R.id.btn_signup)
        signup.setOnClickListener {
            val intent = Intent(this, Signup::class.java)
            startActivity(intent) // Fixed: Added startActivity
        }

        val signin = findViewById<TextView>(R.id.btn) // Renamed ID for clarity
        signin.setOnClickListener {
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent) // Fixed: Added startActivity
        }
    }
}
