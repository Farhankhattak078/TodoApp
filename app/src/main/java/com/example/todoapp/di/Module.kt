package com.example.todoapp.di

import android.content.Context
import androidx.room.Database
import androidx.room.ProvidedTypeConverter
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoapp.model.Dao
import com.example.todoapp.model.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {
    @Provides
    @Singleton
    fun prvoideDatabase(@ApplicationContext context: Context): TodoDatabase
    {
        return Room.databaseBuilder(
            context = context,
            klass = TodoDatabase::class.java,
            name = "Todo.db"
        ).build()
    }

    @Provides
    fun providedao(todoDatabase: TodoDatabase): Dao
    {
       return todoDatabase.dao
    }





}