package com.example.bootcampodev7.di

import android.content.Context
import androidx.room.Room
import com.example.bootcampodev7.data.datasource.ToDoDataSource
import com.example.bootcampodev7.data.repo.ToDoRepository
import com.example.bootcampodev7.room.DataBase
import com.example.bootcampodev7.room.ToDoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideToDoRepository(tds: ToDoDataSource): ToDoRepository {
        return ToDoRepository(tds)
    }

    @Provides
    @Singleton
    fun provideToDoDataSource(tdao: ToDoDao): ToDoDataSource {
        return ToDoDataSource(tdao)
    }

    @Provides
    @Singleton
    fun provideToDoDao(@ApplicationContext context: Context): ToDoDao {
        return Room.databaseBuilder(context, DataBase::class.java, "todo.sql")
            .createFromAsset("todo.sql").build().getToDoDao()
    }
}