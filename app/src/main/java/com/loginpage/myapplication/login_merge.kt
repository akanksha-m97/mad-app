package com.loginpage.myapplication

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class login_merge : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.email_login_activity)

        // Buttons to switch user/admin
        val btnSwitchToUser = findViewById<Button>(R.id.btnSwitchToUser)
        val btnSwitchToAdmin = findViewById<Button>(R.id.btnSwitchToAdmin)

        // Layouts
        val userLoginLayout = findViewById<LinearLayout>(R.id.userLoginLayout)
        val adminLoginLayout = findViewById<LinearLayout>(R.id.adminLoginLayout)

        // User input fields
        val etUserEmail = findViewById<EditText>(R.id.etUserEmail)
        val etUserPassword = findViewById<EditText>(R.id.etUserPassword)
        val btnUserLogin = findViewById<Button>(R.id.btnUserLogin)

        // Admin input fields
        val etAdminEmail = findViewById<EditText>(R.id.etAdminEmail)
        val etAdminPassword = findViewById<EditText>(R.id.etAdminPassword)
        val btnAdminLogin = findViewById<Button>(R.id.btnAdminLogin)

        // Switch to User Login
        btnSwitchToUser.setOnClickListener {
            userLoginLayout.visibility = View.VISIBLE
            adminLoginLayout.visibility = View.GONE
        }

        // Switch to Admin Login
        btnSwitchToAdmin.setOnClickListener {
            userLoginLayout.visibility = View.GONE
            adminLoginLayout.visibility = View.VISIBLE
        }

        // User login button click
        btnUserLogin.setOnClickListener {
            val email = etUserEmail.text.toString()
            val password = etUserPassword.text.toString()
            Toast.makeText(this, "User Login: $email", Toast.LENGTH_SHORT).show()
        }

        // Admin login button click
        btnAdminLogin.setOnClickListener {
            val email = etAdminEmail.text.toString()
            val password = etAdminPassword.text.toString()
            Toast.makeText(this, "Admin Login: $email", Toast.LENGTH_SHORT).show()
        }
    }
}
