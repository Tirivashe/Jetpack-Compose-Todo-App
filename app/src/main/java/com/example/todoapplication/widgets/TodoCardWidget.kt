package com.example.todoapplication.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapplication.model.Todo

@Composable
fun TodoCardWidget(
    todo: Todo,
    onClickDelete: (Todo) -> Unit = {},
    onClickCompleted: (Todo) -> Unit = {}
){
    var isCompleteState by remember(todo) {
        mutableStateOf(todo.isComplete)
    }
    Card(
        shape = RoundedCornerShape(corner = CornerSize(20)),
        elevation = 5.dp,
        backgroundColor = Color.LightGray,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Text(
                    text = todo.title,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    textDecoration = if(isCompleteState) TextDecoration.LineThrough else TextDecoration.None
                )
                Text(
                    text = todo.description,
                    fontSize = 15.sp,
                    color = Color.Black.copy(alpha = 0.5f)
                )
            }

            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier
                        .clickable {
                            onClickDelete(todo)
                        }
                )
                Checkbox(checked = todo.isComplete,
                    onCheckedChange = {
                        onClickCompleted(todo)
                        isCompleteState = !isCompleteState
                    }
                )
            }

        }
    }
}