package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.entity.Notes
import com.example.todoapp.data.repository.TodosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var repo: TodosRepository) : ViewModel() {
    var notlarlistesi = MutableLiveData<List<Notes>>()

    init {
        tumNotlar()
    }

    fun tumNotlar() {
        CoroutineScope(Dispatchers.Main).launch {
            notlarlistesi.value = repo.tumNotlar()//Tetikleme
        }
    }

    fun notuSil(id:Int) {
        CoroutineScope(Dispatchers.Main).launch {
            repo.notuSil(id)
            tumNotlar()      }
    }
    fun notAra(text:String){
        CoroutineScope(Dispatchers.Main).launch {
            notlarlistesi.value = repo.notAra(text)//Tetikleme
        }
    }



}