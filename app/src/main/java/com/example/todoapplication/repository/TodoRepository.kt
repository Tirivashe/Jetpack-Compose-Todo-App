package com.example.todoapplication.repository

import com.example.todoapplication.database.TodoDao
import com.example.todoapplication.model.Todo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TodoRepository @Inject constructor(private val todoDao: TodoDao) {
    fun getAllTodos(): Flow<List<Todo>> = todoDao.getAllTodos()
    suspend fun addTodo(todo: Todo) = todoDao.addTodo(todo)
    suspend fun deleteTodo(todo: Todo) = todoDao.deleteTodo(todo)
    suspend fun updateTodo(todo: Todo) = todoDao.updateTodo(todo)
}