package com.example.dudilugasi.todolist;

import java.util.List;

/**
 * Created by dudilugasi on 10/29/15.
 */
public interface IDataAccess {

    List<TaskItem> GetTasks();

    void addTask(String description);

}


