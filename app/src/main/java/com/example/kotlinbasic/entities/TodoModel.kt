package com.example.kotlinbasic.entities

data class TodoModel(
    var id: Long = 0,
    val name: String,
    var priority: String,
    var date: Long,
    var time: Long,
    var isCompleted: Boolean = false
)
