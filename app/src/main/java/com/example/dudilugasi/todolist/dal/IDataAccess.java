package com.example.dudilugasi.todolist.dal;

import com.example.dudilugasi.todolist.common.TaskItem;

import java.util.List;


public interface IDataAccess {

    List<TaskItem> GetTasks();

    List<TaskItem> GetUncompletedTasks();

    long addTask(TaskItem task);

    int removeTask(TaskItem task);

    int updateTask(TaskItem task);

}


