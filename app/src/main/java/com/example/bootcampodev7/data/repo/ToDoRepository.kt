package com.example.bootcampodev7.data.repo

import com.example.bootcampodev7.data.datasource.ToDoDataSource
import com.example.bootcampodev7.data.entity.ToDoData

class ToDoRepository(var tds: ToDoDataSource) {
    suspend fun save(make: String) = tds.save(make)

    suspend fun update(id: Int, make: String) = tds.update(id, make)

    suspend fun delete(id: Int) = tds.delete(id)

    suspend fun load(): List<ToDoData> = tds.load()

    suspend fun search(searchWords: String) : List<ToDoData> = tds.search(searchWords)
}