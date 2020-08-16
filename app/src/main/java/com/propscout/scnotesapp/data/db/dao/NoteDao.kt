package com.propscout.scnotesapp.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.propscout.scnotesapp.data.db.entity.Note

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note: Note)

    @Query("SELECT * FROM note ORDER BY id DESC")
    fun getAllNotes(): LiveData<List<Note>>

    @Insert
    suspend fun addMultipleNotes(vararg note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

}