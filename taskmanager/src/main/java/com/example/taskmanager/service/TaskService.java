package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private List<Task> tasks = new ArrayList<>();

    // GET ALL TASKS
    public List<Task> getAllTasks() {
        return tasks;
    }

    // ADD TASK
    public void addTask(Task task) {
        tasks.add(task);
    }

    // DELETE TASK
    public void deleteTask(int id) {
        tasks.removeIf(t -> t.getId() == id);
    }

    // MARK COMPLETE
    public void markComplete(int id) {

        for (Task t : tasks) {

            if (t.getId() == id) {
                t.setCompleted(true);
                break;
            }
        }
    }
}