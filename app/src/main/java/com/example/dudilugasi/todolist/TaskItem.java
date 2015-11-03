package com.example.dudilugasi.todolist;

/**
 * Class that represents a Task
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
