package com.example.todoapplication.utils

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.todoapplication.model.Todo
import com.example.todoapplication.widgets.TodoCardWidget

@Composable
fun TodoList(
    todos: List<Todo>,
    onClickDelete: (Todo) -> Unit = {},
    onClickCompleted: (Todo) -> Unit = {}
) {
    LazyColumn {
        items(todos) { todo ->
            TodoCardWidget(
                todo,
                onClickDelete = { onClickDelete(todo) },
                onClickCompleted = { onClickCompleted(todo) }
            )
        }
    }
}
