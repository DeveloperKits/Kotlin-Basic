package com.example.kotlinbasic

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.kotlinbasic.databinding.FragmentToDoListBinding
import com.example.kotlinbasic.db.TodoDatabase

class toDoListFragement : Fragment() {

    private lateinit var binding : FragmentToDoListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentToDoListBinding.inflate(inflater, container, false)

        TodoDatabase.getDB(requireActivity())
            .getTodoDao()
            .getAllTodo()
            .observe(viewLifecycleOwner) {
                Toast.makeText(activity, "${it.size}", Toast.LENGTH_LONG).show()
            }

        binding.addTodo.setOnClickListener{
            findNavController().navigate(R.id.action_toDoListFragement_to_newToDoFragment)
        }

        Log.d("FAB_Position", "X: ${binding.addTodo.x}, Y: ${binding.addTodo.y}")

        return binding.root

    }

}