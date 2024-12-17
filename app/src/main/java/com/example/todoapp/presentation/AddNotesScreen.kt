package com.example.todoapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todoapp.model.TodoState
import com.example.todoapp.viewmodel.events.TodoEvents

@Composable
fun AddNoteScreen(modifier: Modifier = Modifier,
                  events: (TodoEvents)-> Unit,
                  state: TodoState,
                  navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()
        .padding(10.dp)) {
        TextField(value = state.title.value, onValueChange = {
            state.title.value=it
        },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            placeholder = {
                Text("Title")
            },
            label = {
                Text("Title")
            })
        Spacer(modifier = Modifier.height(7.dp))
        TextField(value = state.description.value, onValueChange = {
            state.description.value=it
        },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Description")
            },
            label = {
                Text("Description")
            })
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            events(TodoEvents.addtodo(
                title = state.title.value,
                description = state.description.value
            ))
            navController.popBackStack()
        },
            modifier = Modifier.fillMaxWidth()) {
            Text("Add",
                fontSize = 15.sp)
        }
    }

}
