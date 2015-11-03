package com.example.dudilugasi.todolist;

import java.util.List;

/**
 * Class that responsible for the tasks using the MockDao
 */
public class TaskController implements ITaskController {


    private IDataAccess dao;

    public TaskController() {
        this.dao = MockDAO.getInstance();
    }

    @Override
    public List<TaskItem> getTasks() {
        return dao.GetTasks();
    }

    @Override
    public void addTask(String description) {
        dao.addTask(description);
    }


}
