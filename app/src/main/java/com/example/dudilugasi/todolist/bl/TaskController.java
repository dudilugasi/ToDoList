package com.example.dudilugasi.todolist.bl;

import android.content.Context;

import com.example.dudilugasi.todolist.dal.DAO;
import com.example.dudilugasi.todolist.dal.IDataAccess;
import com.example.dudilugasi.todolist.common.TaskItem;

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
    public List<TaskItem> getUncompletedTasks() {
        return dao.GetUncompletedTasks();
    }

    @Override
    public void addTask(TaskItem item) {
        dao.addTask(item);
    }

    @Override
    public void removeTask(TaskItem item) {
        dao.removeTask(item);
    }

    @Override
    public void updateTask(TaskItem item) {
        dao.updateTask(item);
    }
}
