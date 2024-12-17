package com.example.todoapp.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun addtodo(todo: Todo)

    @Delete
   suspend fun deletetodo(todo: Todo)
   @Query("SELECT * FROM Todo")
    fun getalltodo(): Flow<List<Todo>>

}