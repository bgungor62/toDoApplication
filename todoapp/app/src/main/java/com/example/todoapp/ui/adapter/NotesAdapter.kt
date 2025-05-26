package com.example.todoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.data.entity.Notes
import com.example.todoapp.databinding.CardTasarimBinding
import com.example.todoapp.ui.fragment.AnasayfaFragmentDirections
import com.example.todoapp.ui.viewmodel.AnasayfaViewModel

class NotesAdapter(
    var context: Context,
    var notlarlistesi: List<Notes>,
    var viewModel: AnasayfaViewModel
) : RecyclerView.Adapter<NotesAdapter.CardTasarimHolder>() {
    inner class CardTasarimHolder(val tasarimBinding: CardTasarimBinding) :
        RecyclerView.ViewHolder(tasarimBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimHolder {
        val tasarim = CardTasarimBinding.inflate(LayoutInflater.from(context), parent, false)
        return CardTasarimHolder(tasarim)
    }

    override fun getItemCount(): Int {
        return notlarlistesi.size
    }

    override fun onBindViewHolder(holder: CardTasarimHolder, position: Int) {
        val not = notlarlistesi.get(position)
        val tasarim = holder.tasarimBinding
        tasarim.txtNotes.text = not.name

        tasarim.imgSil.setOnClickListener {
            viewModel.notuSil(not.id)
        }

        tasarim.cardViewTasarim.setOnClickListener {
            val gecis=AnasayfaFragmentDirections.kayitGecis(notes = not)
            Navigation.findNavController(it).navigate(gecis)
        }

    }

}