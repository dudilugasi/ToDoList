package com.example.dudilugasi.todolist;

import java.util.List;

/**
 * Created by dudilugasi on 10/29/15.
 */
public class TaskController implements ITaskController {


    private IDataAccess dao;

    public TaskController() {
        this.dao = new MockDAO();
    }

    @Override
    public List<TaskItem> getTasks() {
        return dao.GetTasks();
    }


}
