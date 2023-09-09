package com.example.kotlinbasic.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BmiViewModel: ViewModel() {

    var bmi: MutableLiveData<Double> = MutableLiveData()
    var category: MutableLiveData<String> = MutableLiveData()

    fun calculateBmi(weight: Double, height: Double){
        bmi.value = weight / (height*height)

        category.value = when(String.format("%.2f", bmi.value).toDouble()){
            in 0.00 .. 18.49 -> underwight
            in 18.50 .. 24.99 -> normal
            in 25.00 .. 29.99 -> overwight
            in 30.00 .. 34.99 -> obesity1
            in 35.00 .. 39.99 -> obesity2
            else -> obesity3
        }
    }

    companion object {
        const val underwight = "UNDER WIGHT"
        const val normal = "NORMAL"
        const val overwight = "OVER WIGHT"
        const val obesity1 = "OBESITY CLASS 1"
        const val obesity2 = "OBESITY CLASS 2"
        const val obesity3 = "OBESITY CLASS 3"
    }
}