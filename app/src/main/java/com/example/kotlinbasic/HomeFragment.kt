package com.example.kotlinbasic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.kotlinbasic.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.calculate.setOnClickListener {
            val weight = binding.weight.text.toString().toDouble()
            val height = binding.height.text.toString().toDouble()

            val bmi = weight / (height*height)

            val bundle = bundleOf("bmi" to bmi)
            findNavController().navigate(R.id.home_to_result, bundle)
        }

        return view
    }



}