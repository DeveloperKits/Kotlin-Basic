package com.example.kotlinbasic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.kotlinbasic.databinding.FragmentNewToDoBinding
import com.example.kotlinbasic.db.TodoDatabase
import com.example.kotlinbasic.dialogs.DatePickerDialog
import com.example.kotlinbasic.dialogs.TimePickerDialog
import com.example.kotlinbasic.entities.TodoModel
import com.example.kotlinbasic.utils.getFormattedDateTime
import com.example.kotlinbasic.utils.priority_normal

class newToDoFragment : Fragment() {

    private lateinit var binding: FragmentNewToDoBinding
    private var priority_text = priority_normal
    private var dateInMillis = System.currentTimeMillis()
    private var timeInMillis = System.currentTimeMillis()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewToDoBinding.inflate(inflater, container, false)

        binding.radioGroup.setOnCheckedChangeListener {radioGroup, i ->
            val radioButton = radioGroup.findViewById<RadioButton>(i)
            priority_text = radioButton.text.toString()
        }

        // save all date on database
        binding.saveData.setOnClickListener{
            val text = binding.inputText.text.toString()
            if (text.isEmpty()){
                binding.inputText.error = "Please provide a valid Text"
                return@setOnClickListener
            }

            val todo = TodoModel(name = text, priority = priority_text, date = dateInMillis, time = timeInMillis)
            TodoDatabase.getDB(requireActivity()).getTodoDao().addTodo(todo)
        }

        binding.sDate.setOnClickListener{
            DatePickerDialog{
                dateInMillis = it
                binding.sDate.text = getFormattedDateTime(dateInMillis, "dd/MM/YYYY")
            }.show(childFragmentManager, "date_picker")

        }

        binding.sTime.setOnClickListener{
            TimePickerDialog{
                timeInMillis = it
                binding.sTime.text = getFormattedDateTime(timeInMillis, "hh:mm a")
            }.show(childFragmentManager, "time_picker")
        }

        return binding.root
    }


}