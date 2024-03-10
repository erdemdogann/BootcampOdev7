package com.example.bootcampodev7.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.gecis(it: View, id: NavDirections){
    findNavController(it).navigate(id)
}