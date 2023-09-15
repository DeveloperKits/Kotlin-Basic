package com.example.kotlinbasic.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinbasic.entities.TodoModel
import com.example.kotlinbasic.repos.TodoRepository

class TodoViewModel(application: Application) : AndroidViewModel(application){
    private val repository = TodoRepository(application)

    fun insertTodoModel(todoModel: TodoModel){
        repository.insertTodo(todoModel)
    }

    fun fetchAllTodo() : LiveData<List<TodoModel>> {
        return repository.getAllTodo()
    }
}