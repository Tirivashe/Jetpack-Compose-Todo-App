package com.example.todoapplication.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.todoapplication.model.Todo
import com.example.todoapplication.ui.theme.TodoApplicationTheme
import com.example.todoapplication.utils.Form
import com.example.todoapplication.utils.TodoList
import com.example.todoapplication.widgets.TextFieldWidget
import com.example.todoapplication.widgets.TodoCardWidget

@Composable
fun MainTodoScreen(todoViewModel: TodoViewModel){
    val todos = todoViewModel.todos.collectAsState().value
    val title = remember{ mutableStateOf("") }
    val description = remember{ mutableStateOf("") }
    TodoApplicationTheme {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ){
            Form(title, description, todoViewModel)
            TodoList(
                todos,
                onClickDelete = { todo ->
                    todoViewModel.delete(todo)
                    },
                onClickCompleted = { todo ->
                    todoViewModel.updateTodo(
                        todo.copy(isComplete = !todo.isComplete)
                    )
                }
            )
        }
    }
}
