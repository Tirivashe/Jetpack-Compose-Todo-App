package com.example.todoapplication.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier

@Composable
fun TextFieldWidget(
    label: String,
    inputText: MutableState<String>
){
    OutlinedTextField(
        value = inputText.value,
        onValueChange = { text ->
            if(
                text.all { char ->
                    char.isLetter() || char.isWhitespace()
                }
            ) inputText.value = text
        },
        label = {
            Text(text = label)
        },
        singleLine = true,
        maxLines = 1,
        enabled = true,
        placeholder = {
            Text(text = label)
        },
        modifier = Modifier
            .fillMaxWidth(0.7f)
        )
}