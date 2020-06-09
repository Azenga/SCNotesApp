package com.propscout.scnotesapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Note(
    val title: String,
    val content: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}