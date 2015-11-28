package com.example.dudilugasi.todolist;

import java.util.List;


public interface IDataAccess {

    List<TaskItem> GetTasks();

    long addTask(TaskItem task);

}


