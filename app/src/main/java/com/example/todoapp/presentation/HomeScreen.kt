package com.example.todoapp.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todoapp.model.Todo
import com.example.todoapp.model.TodoState
import com.example.todoapp.viewmodel.events.TodoEvents

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier,
               state: TodoState,
               navController: NavController,
               events: (TodoEvents) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text("TODO ")
            },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainer
                ))
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("AddNoteScreen")
            }) {
                Icon(Icons.Default.Add,contentDescription = null,)
            }
        }
    ) {
        padding->
        LazyColumn(modifier = Modifier
            .fillMaxSize(),
            contentPadding = padding) {
        items(state.todoList.size)
        {
            index->TodoCard(state = state,
                index=index,
                events = events,
                 )
        }
        }

    }

}

@Composable
fun TodoCard(state: TodoState,
             index: Int,
             events:(TodoEvents)-> Unit, ) {

    ElevatedCard(modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp)
        .height(82.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        elevation = CardDefaults.elevatedCardElevation(
            focusedElevation = 8.dp,
            defaultElevation = 8.dp
        )
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(6.dp)) {
            Row(horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                Text(
                    state.todoList[index].title,
                    Modifier.weight(1f),
                    fontWeight = FontWeight.Bold,

                    maxLines = 1,

                    overflow = TextOverflow.Clip
                )

                IconButton(onClick = {
                    events(TodoEvents.deletetodo(state.todoList[index]))
                }) {
                   Icon(Icons.Default.Delete,
                       contentDescription = null)
                }
                IconButton(onClick = {

                }) {
                    Icon(Icons.Default.Edit,
                        contentDescription = null)
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(state.todoList[index].description,
                fontWeight = FontWeight.W400)

        }}
}


@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_7_PRO)
@Composable
private fun TodoCardPreview() {
   // HomeScreen()
}