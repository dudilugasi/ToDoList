package com.example.dudilugasi.todolist;

import android.content.Context;

import java.util.List;

/**
 * Class that responsible for the tasks using the MockDao
 */
public class TaskController implements ITaskController {
    private Context context;
    private IDataAccess dao;

    public TaskController(Context context) {
        this.context = context;
        this.dao = DAO.getInstance(this.context.getApplicationContext());
    }

    @Override
    public List<TaskItem> getTasks() {
        return dao.GetTasks();
    }

    @Override
    public void addTask(TaskItem item) {
        dao.addTask(item);
    }


}
