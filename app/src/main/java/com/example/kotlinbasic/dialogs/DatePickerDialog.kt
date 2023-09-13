package com.example.kotlinbasic.dialogs

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class DatePickerDialog(val callback: (Long) -> Unit) : DialogFragment(), DatePickerDialog.OnDateSetListener{
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calender = Calendar.getInstance()
        val year = calender.get(Calendar.YEAR)
        val month = calender.get(Calendar.MONTH)
        val day = calender.get(Calendar.DAY_OF_MONTH)
        return DatePickerDialog(requireActivity(), this, year, month, day)
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        val calender = Calendar.getInstance()
        calender.set(p1, p2, p3)
        val timestamp = calender.timeInMillis
        callback(timestamp)
    }
}