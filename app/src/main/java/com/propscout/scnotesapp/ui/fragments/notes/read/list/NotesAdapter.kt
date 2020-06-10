package com.propscout.scnotesapp.ui.fragments.notes.read.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.propscout.scnotesapp.R
import com.propscout.scnotesapp.db.Note

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    var notesList: List<Note>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun populateViews(note: Note) {
            itemView.findViewById<TextView>(R.id.title_text_view).text =
                trimAndConcatenate(note.title)
            itemView.findViewById<TextView>(R.id.content_text_view).text =
                trimAndConcatenate(note.content, 72)
        }

        private fun trimAndConcatenate(s: String, howManyChars: Int = 8) =
            if (s.length > howManyChars) s.take(howManyChars) + "..." else s


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NoteViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.single_note_item,
            parent,
            false
        )
    )

    override fun getItemCount() = notesList?.size ?: 0

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.populateViews(notesList!![position])
    }
}