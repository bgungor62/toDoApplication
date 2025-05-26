package com.example.todoapp.data.datasource

import com.example.todoapp.data.entity.Notes
import com.example.todoapp.room.TodosDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodoDataSource(var todosDao: TodosDao) {


    suspend fun tumNotlar(): List<Notes> = withContext(Dispatchers.IO) {
        return@withContext todosDao.tumNotlar()
    }

    suspend fun notAra(text:String): List<Notes> = withContext(Dispatchers.IO) {
        return@withContext todosDao.notAra(text)
    }


    suspend fun notuSil(id: Int) {
        val silinecekNot = Notes(id, "")
        todosDao.notSil(silinecekNot)

    }

    suspend fun notKaydet(note: String) {
        val newNote = Notes(0, note)
        todosDao.notKaydet(newNote)
    }

    suspend fun notGuncelle(id: Int, name: String) {
        val guncellenecekNot = Notes(id, name)
        todosDao.notGuncelle(guncellenecekNot)
    }

}