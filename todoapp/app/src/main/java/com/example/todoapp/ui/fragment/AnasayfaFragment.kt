package com.example.todoapp.ui.fragment

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.R
import com.example.todoapp.data.entity.Notes
import com.example.todoapp.databinding.FragmentAnasayfaBinding
import com.example.todoapp.ui.adapter.NotesAdapter
import com.example.todoapp.ui.viewmodel.AnasayfaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel
    private lateinit var notes: Notes

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.btnKayit.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.kayitGecis)
        }

        viewModel.notlarlistesi.observe(viewLifecycleOwner) {
            val notlarAdapter = NotesAdapter(requireContext(), it, viewModel)
            binding.rwNotes.adapter = notlarAdapter
        }

        binding.rwNotes.layoutManager = LinearLayoutManager(requireContext())

        binding.btnKayit.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.kayitGecis)

        }

        binding.searchNotes.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(text: String): Boolean {
                viewModel.notAra(text)
                return true
            }

            override fun onQueryTextChange(text: String): Boolean {
                viewModel.notAra(text)
                return true            }

        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.tumNotlar()
    }
}