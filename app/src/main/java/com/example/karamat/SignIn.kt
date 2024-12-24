package com.example.karamat

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)

        // Adjust window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find MaterialButton using the same ID
        val sign = findViewById<MaterialButton>(R.id.btn_login)

        // Handle navigation to MainActivity
        sign.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            // Show toast message
            Toast.makeText(this, "Logged In successfully!!", Toast.LENGTH_SHORT).show()
        }

        // Find the password EditText and CheckBox
        val passwordEditText = findViewById<EditText>(R.id.editTextTextPassword)
        val showPasswordCheckBox = findViewById<CheckBox>(R.id.showPasswordCheckbox)

        // Set the listener for the CheckBox to toggle password visibility
        showPasswordCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Show password
                passwordEditText.inputType = android.text.InputType.TYPE_CLASS_TEXT // Show text
            } else {
                // Hide password
                passwordEditText.inputType = android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD // Hide text
            }

            // Move the cursor to the end of the text after changing the input type
            passwordEditText.setSelection(passwordEditText.text.length)
        }
    }
}
