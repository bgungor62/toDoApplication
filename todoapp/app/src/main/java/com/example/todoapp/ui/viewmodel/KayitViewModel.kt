package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.repository.TodosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class KayitViewModel @Inject constructor(var repo: TodosRepository):ViewModel(){

    fun notKaydet(notes: String){
        CoroutineScope(Dispatchers.Main).launch {
            repo.notKaydet(notes)
        }
    }

    fun notGuncelle(id: Int,name:String){
        CoroutineScope(Dispatchers.Main).launch {
            repo.notGuncelle(id,name)
        }
    }

}