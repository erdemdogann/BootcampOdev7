package com.example.bootcampodev7.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.bootcampodev7.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateViewModel @Inject constructor(var trepo: ToDoRepository) : ViewModel() {
    fun update(id: Int, make: String) {
        CoroutineScope(Dispatchers.Main).launch {
            trepo.update(id, make)
        }
    }
}