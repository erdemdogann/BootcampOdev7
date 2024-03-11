package com.example.bootcampodev7.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bootcampodev7.data.entity.ToDoData
import com.example.bootcampodev7.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var trepo: ToDoRepository) : ViewModel() {
    var toDoMake = MutableLiveData<List<ToDoData>>()

    init {
        load()
    }

    fun delete(id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            trepo.delete(id)
            load()
        }
    }

    fun load() {
        CoroutineScope(Dispatchers.Main).launch {
            toDoMake.value = trepo.load()
        }
    }

    fun search(searchWords: String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                toDoMake.value = trepo.search(searchWords)
            } catch (e: Exception) {
            }
        }
    }
}