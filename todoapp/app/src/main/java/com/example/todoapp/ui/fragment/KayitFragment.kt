package com.example.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todoapp.databinding.FragmentKayitBinding
import com.example.todoapp.ui.viewmodel.AnasayfaViewModel
import com.example.todoapp.ui.viewmodel.KayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KayitFragment : Fragment() {

    private lateinit var binding: FragmentKayitBinding

    private lateinit var viewModel: KayitViewModel


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKayitBinding.inflate(inflater, container, false)

        val bundle: KayitFragmentArgs by navArgs()

        binding.editTextNote.setText(bundle.notes.name.toString())

        binding.btnKaydet.setOnClickListener {
            if (bundle.notes.id!=null && bundle.notes.id>0){
                viewModel.notGuncelle(bundle.notes.id,binding.editTextNote.text.toString())
            }else{
                val name = binding.editTextNote.text.toString()
                viewModel.notKaydet(name)
            }

        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: KayitViewModel by viewModels()
        viewModel = tempViewModel
    }

}