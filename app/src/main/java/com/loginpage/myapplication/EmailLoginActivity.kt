package com.loginpage.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.TextView
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class EmailLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.phonelogin)

        val usernameInput = findViewById<EditText>(R.id.edit_text_id)
        val phoneInput = findViewById<EditText>(R.id.password_toggle)
        val createBtn = findViewById<Button>(R.id.button)
        val switchToEmail = findViewById<TextView>(R.id.switchToEmail)

        createBtn.setOnClickListener {
            val username = usernameInput.text.toString().trim()
            val phone = phoneInput.text.toString().trim()

            if (username.isEmpty()) {
                usernameInput.error = "Enter your username"
                return@setOnClickListener
            }

            if (phone.length != 10 || !phone.all { it.isDigit() }) {
                phoneInput.error = "Enter a valid 10-digit phone number"
                return@setOnClickListener
            }
            // Proceed with phone auth or next activity
            Toast.makeText(this, "Login with phone successful!", Toast.LENGTH_SHORT).show()

        }

        switchToEmail.setOnClickListener {
            val intent = Intent(this, PhoneLoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }
    }

    override fun onBackPressed() {
        // Prevent back navigation from login screen
        moveTaskToBack(true)
    }

}