package com.example.todoapplication.di

import android.content.Context
import androidx.room.Room
import com.example.todoapplication.database.TodoDao
import com.example.todoapplication.database.TodoDatabase
import com.example.todoapplication.repository.TodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesTodoDao(todoDatabase: TodoDatabase): TodoDao = todoDatabase.todoDao()

    @Singleton
    @Provides
    fun providesTodoRepository(todoDao: TodoDao): TodoRepository = TodoRepository(todoDao)

    @Singleton
    @Provides
    fun providesTodoDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        TodoDatabase::class.java,
        "todo_db"
    ).build()
}