package com.example.dudilugasi.todolist;

/**
 * Class that represents a Task
 */
public class TaskItem {

    private String description;
    private long id;
    public TaskItem() {}

    public TaskItem(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
