package com.example.todoapp.data.repository

import com.example.todoapp.data.datasource.TodoDataSource
import com.example.todoapp.data.entity.Notes


class TodosRepository(var todoDataSource: TodoDataSource) {


    suspend fun tumNotlar(): List<Notes> = todoDataSource.tumNotlar()

    suspend fun notuSil(id: Int) = todoDataSource.notuSil(id)

    suspend fun notKaydet(note: String) = todoDataSource.notKaydet(note)

    suspend fun notGuncelle(id: Int, name: String) = todoDataSource.notGuncelle(id, name)

    suspend fun notAra(text: String): List<Notes> = todoDataSource.notAra(text)
}