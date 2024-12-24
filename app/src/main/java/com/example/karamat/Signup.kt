package com.example.karamat

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)

        // Find the root layout
        val rootView = findViewById<LinearLayout>(R.id.main)

        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(rootView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find the MaterialButton for account creation
        val sign = findViewById<MaterialButton>(R.id.btn_neww)

        // Set click listener for MaterialButton to show Toast
        sign.setOnClickListener {
            Toast.makeText(this, "Account created!", Toast.LENGTH_SHORT).show()
        }

        // Find the TextView for navigating to MainActivity (updated ID)
        val home = findViewById<TextView>(R.id.btn_navigate_home)

        // Set click listener for TextView to navigate to MainActivity
        home.setOnClickListener {
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent) // Start MainActivity
        }
    }
}
