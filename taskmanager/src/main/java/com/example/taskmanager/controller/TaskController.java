package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin("*")
public class TaskController {

    @Autowired
    private TaskService service;

    // GET all tasks
    @GetMapping
    public List<Task> getTasks() {
        return service.getAllTasks();
    }

    // ADD task
    @PostMapping
    public String addTask(@RequestBody Task task) {
        service.addTask(task);
        return "Task Added";
    }

    // DELETE task
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id) {
        service.deleteTask(id);
        return "Task Deleted";
    }

    // MARK COMPLETE
    @PutMapping("/{id}")
    public String completeTask(@PathVariable int id) {
        service.markComplete(id);
        return "Task Completed";
    }
}