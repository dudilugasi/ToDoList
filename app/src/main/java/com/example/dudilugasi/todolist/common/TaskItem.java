package com.example.dudilugasi.todolist.common;

/**
 * Class that represents a Task
 */
public class TaskItem {

    private String description;
    private long id;
    private boolean done;
    public TaskItem() {}

    public TaskItem(String description) {
        this.description = description;
        this.done = false;
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

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
