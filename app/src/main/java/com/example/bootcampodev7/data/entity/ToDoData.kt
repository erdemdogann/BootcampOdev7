package com.example.bootcampodev7.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "toDos")
data class ToDoData(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") @NotNull var toDo_id: Int,
    @ColumnInfo(name = "make") @NotNull var toDo_make: String
) : Serializable
