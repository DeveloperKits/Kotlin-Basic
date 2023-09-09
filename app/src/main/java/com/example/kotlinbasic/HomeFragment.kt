package com.example.kotlinbasic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.kotlinbasic.databinding.FragmentHomeBinding
import com.example.kotlinbasic.viewmodels.BmiViewModel


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: BmiViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        viewModel = ViewModelProvider(requireActivity())[BmiViewModel::class.java]

        binding.calculate.setOnClickListener {
            val weight = binding.weight.text.toString().toDouble()
            val height = binding.height.text.toString().toDouble()
            viewModel.calculateBmi(weight, height)

            findNavController().navigate(R.id.home_to_result)
        }

        return view
    }



}