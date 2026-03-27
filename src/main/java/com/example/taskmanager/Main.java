package com.example.taskmanager;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TaskService service = new TaskService();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n--- Task Manager ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Task Title: ");
                    String title = sc.nextLine();

                    service.addTask(new Task(id, title));
                    System.out.println("Task Added!");
                    break;

                case 2:
                    System.out.println("\nTasks:");
                    for (Task task : service.getAllTasks()) {
                        System.out.println(task.getId() + " - " + task.getTitle());
                    }
                    break;

                case 3:
                    System.out.print("Enter Task ID to delete: ");
                    int deleteId = sc.nextInt();
                    service.deleteTask(deleteId);
                    System.out.println("Task Deleted!");
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}