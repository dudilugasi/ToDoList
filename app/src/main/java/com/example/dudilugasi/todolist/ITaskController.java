package com.example.dudilugasi.todolist;

import java.util.List;

/**
 * ITaskController interface
 */
public interface ITaskController {

        List<TaskItem> getTasks();

        void addTask(String description);
}
