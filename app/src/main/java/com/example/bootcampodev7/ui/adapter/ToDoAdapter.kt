package com.example.bootcampodev7.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.bootcampodev7.data.entity.ToDoData
import com.example.bootcampodev7.databinding.CardEditBinding
import com.example.bootcampodev7.ui.fragment.MainFragmentDirections
import com.example.bootcampodev7.ui.viewmodel.MainViewModel
import com.example.bootcampodev7.utils.gecis
import com.google.android.material.snackbar.Snackbar

class ToDoAdapter(
    var toDo: List<ToDoData>,
    var viewModel: MainViewModel
) : RecyclerView.Adapter<ToDoAdapter.CardHolder>() {

    inner class CardHolder(var itemBinding: CardEditBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val binding = CardEditBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardHolder(binding)
    }

    override fun getItemCount(): Int {
        return toDo.size
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        val toDo = toDo.get(position)

        holder.itemBinding.toDoText.text = toDo.toDo_make

        holder.itemBinding.toDoText.setOnClickListener {
            val gecis = MainFragmentDirections.gotoUpdate(todoMake = toDo)
            Navigation.gecis(it, gecis)
        }

        holder.itemBinding.imageView.setOnClickListener {
            Snackbar.make(it, "Are you sure delete this ${toDo.toDo_make} ?", Snackbar.LENGTH_SHORT)
                .setAction("Yes") {
                    viewModel.delete(toDo.toDo_id)
                }.show()
        }
    }
}