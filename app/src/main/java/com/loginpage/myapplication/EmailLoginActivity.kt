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


class EmailLoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var emailField: EditText
    private lateinit var passwordField: EditText
    private lateinit var confirmPasswordField: EditText
    private lateinit var Login: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.email_login_activity)

        auth = FirebaseAuth.getInstance()

        emailField = findViewById<EditText>(R.id.emailEditText)
        passwordField = findViewById<EditText>(R.id.password_toggle)
        Login = findViewById(R.id.button)

        Login.setOnClickListener {
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this,"Login successfull", Toast.LENGTH_SHORT).show()
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
        val loginText: TextView = findViewById(R.id.signup)
        loginText.setOnClickListener {
            val intent = Intent(this, PhoneLoginActivity::class.java)
            startActivity(intent)
        }
    }
}