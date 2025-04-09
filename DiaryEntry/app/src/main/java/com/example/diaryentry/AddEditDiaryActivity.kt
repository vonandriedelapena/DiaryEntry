package com.example.diaryentry

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddEditDiaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_diary)

        findViewById<Button>(R.id.btnSave).setOnClickListener {
            val title = findViewById<EditText>(R.id.etTitle).text.toString()
            val content = findViewById<EditText>(R.id.etContent).text.toString()
            val date = findViewById<EditText>(R.id.etDate).text.toString()

            if (title.isNotBlank() && content.isNotBlank() && date.isNotBlank()) {
                App.diaryEntries.add(DiaryEntry(title, content, date))
                finish()
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}