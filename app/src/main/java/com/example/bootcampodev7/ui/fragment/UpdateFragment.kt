package com.example.bootcampodev7.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.bootcampodev7.R
import com.example.bootcampodev7.databinding.FragmentUpdateBinding
import com.example.bootcampodev7.ui.viewmodel.UpdateViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateFragment : Fragment() {
    private lateinit var binding: FragmentUpdateBinding
    private lateinit var viewModel: UpdateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdateBinding.inflate(inflater, container, false)
        return binding.root

        val bundle: UpdateFragmentArgs by navArgs()
        val take = bundle.todoMake

        binding.updateText.setText(take.toDo_make)

        binding.updateButton.setOnClickListener {
            val make = binding.updateText.text.toString()
            viewModel.update(take.toDo_id, make)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: UpdateViewModel by viewModels()
        viewModel = tempViewModel
    }
}