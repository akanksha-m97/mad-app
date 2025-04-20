package com.loginpage.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException

private fun PhoneLoginActivity.firebaseAuthWithGoogle(text: String) {
    TODO("Not yet implemented")
}

class PhoneLoginActivity : AppCompatActivity() {

    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var firebaseAuth: FirebaseAuth
    private val RC_SIGN_IN = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_phone)

        val usernameInput = findViewById<EditText>(R.id.edit_text_id)
        val phoneInput = findViewById<EditText>(R.id.password_toggle)
        val createBtn = findViewById<Button>(R.id.button)

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


        // Configure Google Sign-In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        val googleSignInClient = GoogleSignIn.getClient(this, gso)
        firebaseAuth = FirebaseAuth.getInstance()

        // Button click listener
        val googleSignInBtn = findViewById<Button>(R.id.button) // Change to your actual button ID
        googleSignInBtn.setOnClickListener {
            signInWithGoogle()
        }
    }

    private fun signInWithGoogle() {
        val signInIntent = googleSignInClient.signInIntent
        signInLauncher.launch(signInIntent)
    }
    private val signInLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            try {
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                Toast.makeText(this, "Google sign-in failed", Toast.LENGTH_SHORT).show()
            }
        }
        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            if (requestCode == RC_SIGN_IN) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                try {
                    val account = task.getResult(ApiException::class.java)
                    firebaseAuthWithGoogle(account.idToken!!)
                } catch (e: ApiException) {
                    Toast.makeText(this, "Google sign-in failed", Toast.LENGTH_SHORT).show()
                }
            }
        }

        fun firebaseAuthWithGoogle(idToken: String) {
            val credential = GoogleAuthProvider.getCredential(idToken, null)
            firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign-in success
                        val user = firebaseAuth.currentUser
                        Toast.makeText(this, "Welcome ${user?.displayName}", Toast.LENGTH_SHORT)
                            .show()
                        // Navigate to next activity
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    } else {
                        // Sign-in failed
                        Toast.makeText(this, "Firebase sign-in failed", Toast.LENGTH_SHORT).show()
                    }
                }





        }

        val switchToEmail = findViewById<TextView>(R.id.switchToEmail)
        switchToEmail.setOnClickListener{
            val intent = Intent(this, EmailLoginActivity::class.java)
            Toast.makeText(this,"Button clicked", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }



    }
}


