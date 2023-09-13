package com.example.kotlinbasic.dialogs

import android.app.Dialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.CalendarView
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment

class TimePickerDialog(val callback: (Long) -> Unit): DialogFragment(), TimePickerDialog.OnTimeSetListener{
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR)
        val minute = calendar.get(Calendar.MINUTE)
        return TimePickerDialog(requireActivity(), this, hour, minute, false)
    }
    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(0, 0, 0, p1, p2)
        callback(calendar.timeInMillis)
    }
}