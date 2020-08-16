package com.propscout.scnotesapp.data.repository

import com.propscout.scnotesapp.data.db.dao.NoteDao
import com.propscout.scnotesapp.data.db.entity.Note

class NoteRepository(private val noteDao: NoteDao) {

    val noteList = noteDao.getAllNotes()

    suspend fun addNote(note: Note) {
        noteDao.addNote(note)
    }
}