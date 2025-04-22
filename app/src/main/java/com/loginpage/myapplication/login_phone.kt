package com.loginpage.eduQuest


import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.loginpage.myapplication.R

class LoginPhoneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_phone)  // This links to login_phone.xml

        // Connect XML views with Kotlin code
        val createButton = findViewById<Button>(R.id.button)
        val googleButton = findViewById<Button>(R.id.button2)
        val appleButton = findViewById<Button>(R.id.button3)
        val phoneEditText = findViewById<EditText>(R.id.password_toggle)

        // "Create" button click
        createButton.setOnClickListener {
            val phone = phoneEditText.text.toString()
            if (phone.isNotEmpty()) {
                Toast.makeText(this, "Creating account with phone: $phone", Toast.LENGTH_SHORT).show()
                // TODO: Add real backend logic (e.g., send OTP or go to next screen)
            } else {
                Toast.makeText(this, "Please enter your phone number", Toast.LENGTH_SHORT).show()
            }
        }

        // "Continue with Google" button
        googleButton.setOnClickListener {
            Toast.makeText(this, "Google login clicked", Toast.LENGTH_SHORT).show()
            // TODO: Add Google Sign-In
        }

        // "Continue with Apple" button
        appleButton.setOnClickListener {
            Toast.makeText(this, "Apple login clicked", Toast.LENGTH_SHORT).show()
            // TODO: Add Apple login logic
        }
    }
}

