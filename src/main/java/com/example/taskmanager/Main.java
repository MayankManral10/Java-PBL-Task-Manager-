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
            System.out.println("\n--- TASK MANAGER ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Complete");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Due Date (YYYY-MM-DD): ");
                    String date = sc.nextLine();

                    System.out.print("Enter Priority (low/medium/high): ");
                    String priority = sc.nextLine();

                    service.addTask(new Task(id, title, date, priority));
                    System.out.println("Task Added!");
                    break;

                case 2:
                    service.viewTasks();
                    break;

                case 3:
                    System.out.print("Enter ID to mark complete: ");
                    int compId = sc.nextInt();
                    service.markComplete(compId);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();
                    service.deleteTask(delId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}