package com.example.todoapp.di

import android.content.Context
import androidx.room.Room
import com.example.todoapp.data.datasource.TodoDataSource
import com.example.todoapp.data.repository.TodosRepository
import com.example.todoapp.room.TodosDao
import com.example.todoapp.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideTodosRepository(todosDataSource: TodoDataSource): TodosRepository {
        return TodosRepository(todosDataSource)
    }

    @Provides
    @Singleton
    fun provideTodoDataSource(todosDao: TodosDao): TodoDataSource {
        return TodoDataSource(todosDao)
    }

    @Provides
    @Singleton
    fun provideTodosDao(@ApplicationContext context: Context) : TodosDao {
        val veritabani = Room.databaseBuilder(context, Veritabani::class.java,"deneme.sqlite")
            .createFromAsset("deneme.sqlite")
            .build()
        return veritabani.getTodosDao()
    }


}