package com.example.diaryentry

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val user = App.currentUser
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        etUsername.setText(user?.username)
        etEmail.setText(user?.email)
        etPassword.setText(user?.password)

        findViewById<Button>(R.id.btnSaveProfile).setOnClickListener {
            val newUsername = etUsername.text.toString()
            val newEmail = etEmail.text.toString()
            val newPassword = etPassword.text.toString()

            if (newUsername.length < 8 || newEmail.length < 8 || newPassword.length < 8) {
                Toast.makeText(this, "Each field must be 8+ characters", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!newEmail.endsWith("@gmail.com")) {
                Toast.makeText(this, "Email must be a valid Gmail", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!newPassword.matches(".*[0-9].*".toRegex()) || !newPassword.matches(".*[!@#\$%^&*()].*".toRegex())) {
                Toast.makeText(this, "Password must contain numbers and special characters", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            user?.username = newUsername
            user?.email = newEmail
            user?.password = newPassword
            Toast.makeText(this, "Profile updated", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btnLogout).setOnClickListener {
            App.currentUser = null
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}