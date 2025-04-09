package com.example.diaryentry

import android.app.Application

class App : Application() {
    companion object {
        val users = mutableListOf(
            User("testuser", "testuser@gmail.com", "Test@1234")
        )
        var currentUser: User? = null
        val diaryEntries = mutableListOf<DiaryEntry>()
        val archiveEntries = mutableListOf<DiaryEntry>()
    }
}