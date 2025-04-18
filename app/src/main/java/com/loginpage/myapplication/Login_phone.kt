package com.loginpage.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import android.widget.EditText
import android.widget.Button
import android.content.Intent
import androidx.core.content.ContextCompat
import kotlin.math.sign


class Login_phone : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_phone)

        // Email Login
        findViewById<Button>(R.id.button).setOnClickListener {

            val drawable = ContextCompat.getDrawable(
                this,
                R.drawable.whatsapp_image_2025_04_08_at_23_10_21_8c5cc88a
            )
            val phoneEditText = findViewById<EditText>(R.id.password_toggle)
            val usernameEditText = findViewById<EditText>(R.id.edit_text_id).text.toString()
            if (usernameEditText.isEmpty()) {
                Toast.makeText(
                    this,
                    "please fill in all fields",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(this, "Login successfully", Toast.LENGTH_SHORT).show()

            }
        }
       text.setOnClickListener {
            Toast.makeText(this, "redirecting to email page....", Toast.LENGTH_SHORT).show()
            val intent= Intent(this, LoginActivity::class.java)
                startActivity(intent)

        }

    }
}

