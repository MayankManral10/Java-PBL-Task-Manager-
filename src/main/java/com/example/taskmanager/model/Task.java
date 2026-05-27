package com.example.taskmanager.model;

public class Task {
    private int id;
    private String title;
    private String dueDate;
    private String priority;
    private boolean completed;

    public Task(int id, String title, String dueDate, String priority) {
        this.id = id;
        this.title = title;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDueDate() { return dueDate; }
    public String getPriority() { return priority; }
    public boolean isCompleted() { return completed; }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}