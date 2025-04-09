package com.example.diaryentry

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var listView: ListView
    lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.diaryListView)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, App.diaryEntries.map { it.title })
        listView.adapter = adapter

        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            startActivity(Intent(this, AddEditDiaryActivity::class.java))
        }
        findViewById<Button>(R.id.btnProfile).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
        findViewById<Button>(R.id.btnArchive).setOnClickListener {
            startActivity(Intent(this, ArchiveActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.clear()
        adapter.addAll(App.diaryEntries.map { it.title })
        adapter.notifyDataSetChanged()
    }
}