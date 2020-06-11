package com.propscout.scnotesapp.db

import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note: Note)

    @Query("SELECT * FROM note ORDER BY id DESC")
    suspend fun getAllNotes(): List<Note>

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNoteById(id: Int)

    @Insert
    suspend fun addMultipleNotes(vararg note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteItem(note: Note)
}