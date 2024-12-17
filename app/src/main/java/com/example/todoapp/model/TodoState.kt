package com.example.todoapp.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class TodoState(
    val todoList: List<Todo> = emptyList(),
    val title: MutableState<String> = mutableStateOf(""),
    val description: MutableState<String> = mutableStateOf("")
)
