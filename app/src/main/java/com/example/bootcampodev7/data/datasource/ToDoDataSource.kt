package com.example.bootcampodev7.data.datasource

import com.example.bootcampodev7.data.entity.ToDoData
import com.example.bootcampodev7.room.ToDoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoDataSource(var tdao: ToDoDao) {

    suspend fun save(make: String) {
        val newMake = ToDoData(0, make)
        tdao.save(newMake)
    }

    suspend fun update(id: Int, make: String) {
        val updateMake = ToDoData(id, make)
        tdao.update(updateMake)
    }

    suspend fun delete(id: Int) {
        val deleteMake = ToDoData(id, "")
        tdao.delete(deleteMake)
    }

    suspend fun load(): List<ToDoData> = withContext(Dispatchers.IO) {
        return@withContext tdao.load()
    }

    suspend fun search(searchWords: String): List<ToDoData> = withContext(Dispatchers.IO) {
        return@withContext tdao.search(searchWords)
    }
}