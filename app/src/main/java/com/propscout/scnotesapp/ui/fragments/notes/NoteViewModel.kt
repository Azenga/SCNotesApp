package com.propscout.scnotesapp.ui.fragments.notes

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.propscout.scnotesapp.data.db.NoteDatabase
import com.propscout.scnotesapp.data.db.entity.Note
import com.propscout.scnotesapp.data.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(private val context: Context) : ViewModel() {

    private val db by lazy { NoteDatabase(context) }

    private val repository by lazy { NoteRepository(db.getNoteDao()) }

    val noteList: LiveData<List<Note>> = repository.noteList

    fun addNote(note: Note) {
        viewModelScope.launch {
            repository.addNote(note)
        }
    }
}