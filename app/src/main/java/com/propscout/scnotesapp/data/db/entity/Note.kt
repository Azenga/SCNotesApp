package com.propscout.scnotesapp.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    val title: String,
    val content: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}