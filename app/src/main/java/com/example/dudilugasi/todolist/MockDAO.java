package com.example.dudilugasi.todolist;

import java.util.ArrayList;
import java.util.List;

/**
 * MockDao responsible for storing , getting and adding for a list of tasks
 */
public class MockDAO implements IDataAccess {

    private static MockDAO instance;

    List<TaskItem> taskItems = new ArrayList<TaskItem>();

    public static MockDAO getInstance()
    {
        if(instance ==  null)
            instance = new MockDAO();
        return instance;
    }

    @Override
    public List<TaskItem> GetTasks() {
        return taskItems;
    }

    @Override
    public void addTask(String description) {
        TaskItem task = new TaskItem(description);
        taskItems.add(task);
    }
}
