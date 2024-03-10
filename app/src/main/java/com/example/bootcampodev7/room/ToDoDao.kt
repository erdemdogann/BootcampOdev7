package com.example.bootcampodev7.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.bootcampodev7.data.entity.ToDoData

@Dao
interface ToDoDao {
    @Query("SELECT * FROM toDos")
    suspend fun load(): List<ToDoData>

    @Insert
    suspend fun save(todo: ToDoData)

    @Update
    suspend fun update(todo: ToDoData)

    @Delete
    suspend fun delete(todo: ToDoData)

    @Query("SELECT * FROM toDos WHERE make like '%'||:searchingWords||'%'")
    suspend fun search(searchingWords: String): List<ToDoData>
}