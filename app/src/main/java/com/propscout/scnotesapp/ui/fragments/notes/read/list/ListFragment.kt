package com.propscout.scnotesapp.ui.fragments.notes.read.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.propscout.scnotesapp.R
import com.propscout.scnotesapp.data.db.entity.Note
import com.propscout.scnotesapp.ui.fragments.BaseFragment
import com.propscout.scnotesapp.ui.fragments.notes.NoteViewModel
import com.propscout.scnotesapp.ui.fragments.notes.NoteViewModelProviderFactory
import com.propscout.scnotesapp.ui.fragments.notes.read.NoteItemClickedListener

class ListFragment : BaseFragment(), NoteItemClickedListener {

    private lateinit var navController: NavController
    private lateinit var notesRecyclerView: RecyclerView
    private lateinit var viewModel: NoteViewModel

    private val notesAdapter: NotesAdapter by lazy {
        NotesAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()

        view.findViewById<FloatingActionButton>(R.id.add_note_fab).setOnClickListener {
            navController.navigate(R.id.addFragment)
        }

        notesRecyclerView = view.findViewById(R.id.notes_recycler_view)

        notesRecyclerView.setHasFixedSize(true)
        notesRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        notesRecyclerView.adapter = notesAdapter

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val factory = NoteViewModelProviderFactory(requireContext())
        viewModel = ViewModelProvider(this, factory).get(NoteViewModel::class.java)

        viewModel.noteList.observe(viewLifecycleOwner, Observer { noteList ->
            notesAdapter.notesList = noteList
        })
    }

    override fun itemClicked(note: Note) {

        findNavController().navigate(R.id.detailFragment)

    }

}