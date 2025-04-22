package com.loginpage.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.util.Log
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class PhoneLoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var emailField: EditText
    private lateinit var passwordField: EditText
    private lateinit var confirmPasswordField: EditText
    private lateinit var signupButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.phone_login_activity)

        auth = FirebaseAuth.getInstance()

        emailField = findViewById<EditText>(R.id.emailEditText2)
        passwordField = findViewById<EditText>(R.id.password_toggle)
        confirmPasswordField = findViewById<EditText>(R.id.password_toggle1)
        signupButton = findViewById(R.id.button)

        signupButton.setOnClickListener {
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()
            val confirmPassword = confirmPasswordField.text.toString().trim()

            if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("Signup","Signup Successful !")
                        // Navigate to another activity or home screen
                        val intent = Intent(this, Dashboard_activity::class.java)
                        startActivity(intent)
                        finish()

                    } else {
                        val errorMessage= task.exception?.message?:"Unknown error"
                        Log.e("Signup","Signup failed")
                    }

                }
        }
        val loginText: TextView = findViewById(R.id.login)
        loginText.setOnClickListener {
            val intent = Intent(this, EmailLoginActivity::class.java)
            startActivity(intent)
        }
    }
}




