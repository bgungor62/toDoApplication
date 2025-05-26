package com.example.todoapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoapp.data.entity.Notes


@Database(entities = [Notes::class], version = 1)
abstract class Veritabani : RoomDatabase() {
    abstract fun getTodosDao() : TodosDao
}