package com.example.todoapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("Todo")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val title: String ="",
    val description: String =""
)
