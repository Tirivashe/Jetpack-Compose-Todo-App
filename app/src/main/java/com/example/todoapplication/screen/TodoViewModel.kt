package com.example.todoapplication.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapplication.model.Todo
import com.example.todoapplication.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor (private val todoRepository: TodoRepository): ViewModel() {
    private val _todos = MutableStateFlow<List<Todo>>(emptyList())
    val todos = _todos.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            todoRepository.getAllTodos().distinctUntilChanged().collect { todoList ->
                if(!todoList.isNullOrEmpty()) _todos.value = todoList
            }
        }
    }

    fun addTodo(todo: Todo) = viewModelScope.launch { todoRepository.addTodo(todo) }
    fun updateTodo(todo: Todo) = viewModelScope.launch { todoRepository.updateTodo(todo) }
    fun delete(todo: Todo) = viewModelScope.launch { todoRepository.deleteTodo(todo) }
}