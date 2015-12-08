package com.example.dudilugasi.todolist.bl;

import com.example.dudilugasi.todolist.common.TaskItem;

import java.util.List;

/**
 * ITaskController interface
 */
public interface ITaskController {

        List<TaskItem> getTasks();

        List<TaskItem> getUncompletedTasks();

        void addTask(TaskItem item);

        void removeTask(TaskItem item);

        void updateTask(TaskItem item);
}
