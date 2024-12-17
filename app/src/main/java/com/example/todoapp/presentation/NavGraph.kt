package com.example.todoapp.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.model.TodoState
import com.example.todoapp.viewmodel.events.TodoEvents


@Composable
fun Navgraph(
  state: TodoState,
  events: (TodoEvents) -> Unit
)
{
    val navController= rememberNavController()
  NavHost(navController = navController, startDestination = "HomeScreen") {
    composable("HomeScreen"){
      HomeScreen(state=state,
        navController = navController,
        events = events)
    }
    composable("AddNoteScreen")
    {
      AddNoteScreen(state = state, events = events,
        navController = navController)
    }


  }
  }

