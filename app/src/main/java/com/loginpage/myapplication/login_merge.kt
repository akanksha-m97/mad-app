package com.example.login_merge

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.login_merge.R
class LoginActivity : AppCompatActivity() {

    private lateinit var btnSwitchToUser: Button
    private lateinit var btnSwitchToAdmin: Button
    private lateinit var userLayout: LinearLayout
    private lateinit var adminLayout: LinearLayout
    private lateinit var userEmail: EditText
    private lateinit var userPassword: EditText
    private lateinit var adminEmail: EditText
    private lateinit var adminPassword: EditText
    private lateinit var btnUserLogin: Button
    private lateinit var btnAdminLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize views
        btnSwitchToUser = findViewById(R.id.btnSwitchToUser)
        btnSwitchToAdmin = findViewById(R.id.btnSwitchToAdmin)
        userLayout = findViewById(R.id.userLoginLayout)
        adminLayout = findViewById(R.id.adminLoginLayout)
        userEmail = findViewById(R.id.etUserEmail)
        userPassword = findViewById(R.id.etUserPassword)
        adminEmail = findViewById(R.id.etAdminEmail)
        adminPassword = findViewById(R.id.etAdminPassword)
        btnUserLogin = findViewById(R.id.btnUserLogin)
        btnAdminLogin = findViewById(R.id.btnAdminLogin)

        // Switch buttons
        btnSwitchToUser.setOnClickListener {
            userLayout.visibility = View.VISIBLE
            adminLayout.visibility = View.GONE
        }

        btnSwitchToAdmin.setOnClickListener {
            userLayout.visibility = View.GONE
            adminLayout.visibility = View.VISIBLE
        }

        // Handle login buttons
        btnUserLogin.setOnClickListener {
            val email = userEmail.text.toString()
            val pass = userPassword.text.toString()
            Toast.makeText(this, "User Login: $email", Toast.LENGTH_SHORT).show()
        }

        btnAdminLogin.setOnClickListener {
            val email = adminEmail.text.toString()
            val pass = adminPassword.text.toString()
            Toast.makeText(this, "Admin Login: $email", Toast.LENGTH_SHORT).show()
        }
    }
}
