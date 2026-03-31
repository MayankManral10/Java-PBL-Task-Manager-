package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import java.util.*;

public class TaskService {

    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        for (Task t : tasks) {
            System.out.println(
                t.getId() + " | " +
                t.getTitle() + " | " +
                t.getDueDate() + " | " +
                t.getPriority() + " | " +
                (t.isCompleted() ? "Completed" : "Pending")
            );
        }
    }

    public void deleteTask(int id) {
        tasks.removeIf(t -> t.getId() == id);
    }

    public void markComplete(int id) {
        for (Task t : tasks) {
            if (t.getId() == id) {
                t.setCompleted(true);
                break;
            }
        }
    }
}