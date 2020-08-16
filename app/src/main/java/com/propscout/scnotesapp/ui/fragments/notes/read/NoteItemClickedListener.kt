package com.propscout.scnotesapp.ui.fragments.notes.read

import com.propscout.scnotesapp.data.db.entity.Note

interface NoteItemClickedListener {

    fun itemClicked(note: Note)

}