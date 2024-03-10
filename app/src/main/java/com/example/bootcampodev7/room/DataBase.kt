package com.example.bootcampodev7.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bootcampodev7.data.entity.ToDoData

@Database(entities = [ToDoData::class], version = 1)
abstract class DataBase : RoomDatabase() {
    abstract fun getToDoDao(): ToDoDao
}