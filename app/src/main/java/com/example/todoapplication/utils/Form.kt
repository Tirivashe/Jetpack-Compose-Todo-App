package com.example.todoapplication.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todoapplication.model.Todo
import com.example.todoapplication.screen.TodoViewModel
import com.example.todoapplication.widgets.TextFieldWidget

@Composable
fun Form(
    title: MutableState<String>,
    description: MutableState<String>,
    todoViewModel: TodoViewModel
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        TextFieldWidget(label = "Title", inputText = title)
        TextFieldWidget(label = "Description", inputText = description)
        Button(
            onClick = {
                if(title.value.isNotEmpty() || title.value.isNotBlank()){
                    todoViewModel.addTodo(Todo(title = title.value, description = description.value))
                    title.value = ""
                    description.value = ""
                }
            }
        ) {
            Text(text = "Add Todo")
        }

    }
}