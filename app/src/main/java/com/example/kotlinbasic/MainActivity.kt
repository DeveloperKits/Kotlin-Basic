package com.example.kotlinbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinbasic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var resultSum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null){
            resultSum = savedInstanceState.getInt("result")
            binding.result.text = resultSum.toString()
        }

        binding.calculate.setOnClickListener{
            resultSum =
                binding
                .editTextNumber
                .text
                .toString()
                .toInt() +
                    binding
                    .editTextNumber2
                    .text
                    .toString()
                    .toInt()

            binding.result.text = resultSum.toString()
        }

    }

    // when orientation screen change then show same calculate result data
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("result", resultSum)
        super.onSaveInstanceState(outState)
    }
}