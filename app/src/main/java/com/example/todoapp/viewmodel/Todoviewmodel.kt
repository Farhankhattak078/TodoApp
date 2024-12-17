package com.example.todoapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.model.Dao
import com.example.todoapp.model.Todo
import com.example.todoapp.model.TodoState
import com.example.todoapp.viewmodel.events.TodoEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Todoviewmodel @Inject constructor(private val dao: Dao): ViewModel() {
    private val _todostate = MutableStateFlow(TodoState())
    val todoState=_todostate

init {
    getalltodo()
}
    fun getalltodo()
    {

        dao.getalltodo()
            .onEach {
                todolist->_todostate.value=_todostate.value.copy(
                    todoList = todolist
                )
            }.launchIn(viewModelScope)

    }

   fun onEvenets(events: TodoEvents)
   {
       when(events)
       {
           is TodoEvents.addtodo ->
           {
               val todo= Todo(
                   title = todoState.value.title.value,
                   description = todoState.value.description.value
               )

               viewModelScope.launch{
                   dao.addtodo(todo)
               }
               _todostate.update {
                   it.copy(
                       title = mutableStateOf(""),
                       description = mutableStateOf(""),
                   )
               }
           }

           is TodoEvents.deletetodo -> {
               viewModelScope.launch{
                   dao.deletetodo(todo = events.todo)
               }
           }


   }
}}