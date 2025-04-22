package com.loginpage.myapplication

// Replace with your actual package name

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class NotesLectures : AppCompatActivity() {

    private lateinit var userNameText: TextView
    private lateinit var textView: TextView
    private lateinit var mainGriD1: CardView
    private lateinit var mainGriD2: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_lectures) // Replace with the actual layout file name like R.layout.activity_notes_lectures

        // Initialize views
        userNameText = findViewById(R.id.textView) // Change ID if username TextView has a different one
        textView = findViewById(R.id.textView)
        mainGriD1 = findViewById(R.id.mainGriD)
        mainGriD2 = findViewById(R.id.mainGrid)

        // Set the username text
        userNameText.text = "Hello, Ankita!"

        // Set click actions
        mainGriD1.setOnClickListener {
            Toast.makeText(this, "First card clicked", Toast.LENGTH_SHORT).show()
        }

        mainGriD2.setOnClickListener {
            Toast.makeText(this, "Second card clicked", Toast.LENGTH_SHORT).show()
        }
    }
}
