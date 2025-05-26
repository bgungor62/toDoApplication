package com.example.todoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.data.entity.Notes


@Dao
interface TodosDao {
    @Query("SELECT * FROM notes")
    suspend fun tumNotlar(): List<Notes>

    @Delete
    suspend fun notSil(notes: Notes)

    @Insert
    suspend fun notKaydet(notes: Notes)

    @Update
    suspend fun notGuncelle(notes: Notes)

    @Query("SELECT * FROM notes WHERE name LIKE '%' || :text  || '%'")
    suspend fun notAra(text: String): List<Notes>
}