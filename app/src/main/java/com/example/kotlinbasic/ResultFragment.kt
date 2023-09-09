package com.example.kotlinbasic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
//import androidx.navigation.fragment.navArgs
import com.example.kotlinbasic.databinding.FragmentResultBinding
import com.example.kotlinbasic.viewmodels.BmiViewModel

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding
    private lateinit var viewModel: BmiViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        val view = binding.root

        viewModel = ViewModelProvider(requireActivity())[BmiViewModel::class.java]

        viewModel.bmi.observe(viewLifecycleOwner) {
            binding.score.text = String.format("%.2f", it)
        }

        viewModel.category.observe(viewLifecycleOwner) {
            binding.catagory.text = it
        }

        /*val string: ResultFragmentArgs by navArgs()
        binding.type.text = string.demoString*/

        return view
    }



}