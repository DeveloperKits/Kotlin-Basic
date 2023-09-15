package com.example.kotlinbasic.repos

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.kotlinbasic.daos.TodoDao
import com.example.kotlinbasic.db.TodoDatabase
import com.example.kotlinbasic.entities.TodoModel

class TodoRepository (context: Context) {
    private val todoDao : TodoDao = TodoDatabase.getDB(context).getTodoDao()

    fun insertTodo(todoModel: TodoModel){
        todoDao.addTodo(todoModel)
    }

    fun getAllTodo() : LiveData<List<TodoModel>> {
        return todoDao.getAllTodo()
    }

}