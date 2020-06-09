package com.propscout.scnotesapp.ui.fragments.notes.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.propscout.scnotesapp.R
import com.propscout.scnotesapp.db.Note
import com.propscout.scnotesapp.db.NoteDatabase
import com.propscout.scnotesapp.ui.fragments.BaseFragment
import com.propscout.scnotesapp.ui.utils.toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddFragment : BaseFragment() {

    private lateinit var titleField: TextInputEditText
    private lateinit var contentField: TextInputEditText

    private lateinit var viewModel: AddViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Register the views
        titleField = view.findViewById(R.id.title_field)
        contentField = view.findViewById(R.id.content_field)

        //Attach a click listener on the create note button
        view.findViewById<Button>(R.id.create_note_btn).setOnClickListener {

            //Get user input
            val title = titleField.text.toString()
            val content = contentField.text.toString()

            if (title.isEmpty()) {
                titleField.error = "Title is required"
                titleField.requestFocus()
                return@setOnClickListener
            }

            if (content.isEmpty()) {
                contentField.error =
                    "Content is required"
                contentField.requestFocus()
                return@setOnClickListener
            }

            val note = Note(title, content)

            /**
             * Using a custom fragment life based Coroutine scope
             */
            launch {
                NoteDatabase(requireContext()).getNoteDao().addNote(note)

                withContext(Dispatchers.Main) {
                    requireContext().toast(R.string.note_saved_message)
                    clearCache()
                }
            }

        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddViewModel::class.java)
    }

    private fun clearCache() {
        titleField.setText("")
        contentField.setText("")
    }

}