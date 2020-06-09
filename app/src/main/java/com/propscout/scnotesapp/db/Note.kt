package com.propscout.scnotesapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val content: String
)