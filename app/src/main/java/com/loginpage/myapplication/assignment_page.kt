package com.example.eduquest

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    // Views
    private lateinit var titleEditText: EditText
    private lateinit var descEditText: EditText
    private lateinit var dateEditText: EditText
    private lateinit var uploadButton: Button
    private lateinit var uploadedAssignmentsLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_layout)

        // Initialize views
        titleEditText = findViewById(R.id.assignmentTitle)
        descEditText = findViewById(R.id.assignmentDesc)
        dateEditText = findViewById(R.id.assignmentDate)
        uploadButton = findViewById(R.id.uploadBtn)
        uploadedAssignmentsLayout = findViewById(R.id.uploadedAssignmentsLayout)

        uploadButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val desc = descEditText.text.toString()
            val date = dateEditText.text.toString()

            if (title.isNotEmpty() && desc.isNotEmpty() && date.isNotEmpty()) {
                addAssignmentCard(title, desc, date)
                titleEditText.text.clear()
                descEditText.text.clear()
                dateEditText.text.clear()
                Toast.makeText(this, "Assignment Uploaded!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun addAssignmentCard(title: String, desc: String, date: String) {
        val card = LinearLayout(this)
        card.orientation = LinearLayout.VERTICAL
        card.setPadding(20, 20, 20, 20)
        card.setBackgroundResource(android.R.color.darker_gray)
        card.setPadding(20, 20, 20, 20)

        val titleView = TextView(this)
        titleView.text = title
        titleView.textSize = 18f
        titleView.setPadding(0, 0, 0, 8)

        val descView = TextView(this)
        descView.text = desc

        val dateView = TextView(this)
        dateView.text = "Due: $date"
        dateView.setPadding(0, 8, 0, 4)

        val fileView = TextView(this)
        fileView.text = "$title.pdf"
        fileView.setPadding(0, 4, 0, 0)
        fileView.textSize = 12f

        // Add to layout
        card.addView(titleView)
        card.addView(descView)
        card.addView(dateView)
        card.addView(fileView)

        // Add card to main layout
        uploadedAssignmentsLayout.addView(card)
    }
}
