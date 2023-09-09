package com.example.kotlinbasic.viewmodels

import androidx.lifecycle.ViewModel

class BmiViewModel: ViewModel() {

    var bmi = 0.0
    var category = ""

    fun calculateBmi(weight: Double, height: Double){
        bmi = weight / (height*height)

        category = when(String.format("%.2f", bmi).toDouble()){
            in 0.00 .. 18.49 -> underwight
            in 18.50 .. 24.99 -> normal
            in 25.00 .. 29.99 -> overwight
            in 30.00 .. 34.99 -> obesity1
            in 35.00 .. 39.99 -> obesity2
            else -> obesity3
        }
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