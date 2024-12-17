package com.example.todoapp.viewmodel.events

import com.example.todoapp.model.Todo

sealed interface TodoEvents {
    data class addtodo(
        val title: String = "",
        val description: String=""): TodoEvents
    data class deletetodo(
        val todo: Todo
    ): TodoEvents

}