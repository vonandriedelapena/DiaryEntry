package com.example.diaryentry

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        findViewById<Button>(R.id.btnRegister).setOnClickListener {
            val username = findViewById<EditText>(R.id.etUsername).text.toString()
            val email = findViewById<EditText>(R.id.etEmail).text.toString()
            val password = findViewById<EditText>(R.id.etPassword).text.toString()

            if (username.length < 8 || email.length < 8 || password.length < 8) {
                Toast.makeText(this, "All fields must be at least 8 characters", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!email.endsWith("@gmail.com")) {
                Toast.makeText(this, "Email must be a valid Gmail", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!password.matches(".*[0-9].*".toRegex()) || !password.matches(".*[!@#\$%^&*()].*".toRegex())) {
                Toast.makeText(this, "Password must contain numbers and special characters", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val user = User(username, email, password)
            App.users.add(user)
            App.currentUser = user
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}