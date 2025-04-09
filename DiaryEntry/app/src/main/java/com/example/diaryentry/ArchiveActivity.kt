package com.example.diaryentry

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ArchiveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_archive)

        val listView = findViewById<ListView>(R.id.archiveListView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, App.archiveEntries.map { it.title })
        listView.adapter = adapter
    }
}