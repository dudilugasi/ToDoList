package com.example.dudilugasi.todolist;

/**
 * Created by dudilugasi on 10/29/15.
 */
public class TaskItem {

    private String description;

    public TaskItem(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
