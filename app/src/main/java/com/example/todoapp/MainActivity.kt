package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.example.todoapp.presentation.Navgraph
import com.example.todoapp.viewmodel.Todoviewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
         val viewmodel: Todoviewmodel by viewModels()

        setContent {
            val state=viewmodel.todoState.collectAsState().value
            val events=viewmodel::onEvenets
            Navgraph(
                state = state,
                events = events
            )

        }
    }
}
