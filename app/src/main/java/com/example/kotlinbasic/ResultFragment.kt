package com.example.kotlinbasic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinbasic.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        val view = binding.root

        val score = arguments?.getDouble("bmi")
        binding.score.text = String.format("%.2f", score)

        val category = when(String.format("%.2f", score).toDouble()){
            in 0.00 .. 18.49 -> underwight
            in 18.50 .. 24.99 -> normal
            in 25.00 .. 29.99 -> overwight
            in 30.00 .. 34.99 -> obesity1
            in 35.00 .. 39.99 -> obesity2
            else -> obesity3
        }

        binding.catagory.text = category

        return view
    }

    companion object {
        val underwight = "UNDER WIGHT"
        val normal = "NORMAL"
        val overwight = "OVER WIGHT"
        val obesity1 = "OBESITY CLASS 1"
        val obesity2 = "OBESITY CLASS 2"
        val obesity3 = "OBESITY CLASS 3"
    }

}