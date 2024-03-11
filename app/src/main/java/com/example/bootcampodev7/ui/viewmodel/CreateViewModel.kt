package com.example.bootcampodev7.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.bootcampodev7.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateViewModel @Inject constructor(var trepo: ToDoRepository) : ViewModel() {
    fun save(make: String) {
        CoroutineScope(Dispatchers.Main).launch {
            trepo.save(make)
        }
    }
}