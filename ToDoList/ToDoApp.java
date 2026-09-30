package ToDoList;

import java.util.*;

public class ToDoApp {
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.println("********-To Do List-********");
            System.out.println("1- Add Task");
            System.out.println("2- View Task");
            System.out.println("3- Mark Task as Done");
            System.out.println("4- Delete Task");
            System.out.println("0- Exit Program");
            System.out.println("****************************");
            System.out.println("Enter your choice number: ");

            try {
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        addTask(sc);
                        break;
                    case 2:
                        viewTasks();
                        break;
                    case 3:
                        markTaskDone(sc);
                        break;
                    case 4:
                        deleteTask(sc);
                        break;
                    case 0:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice, Please try again");
                        System.out.println();
                }
            }

            catch (InputMismatchException e) {
                System.out.println("Please enter a number");
                sc.nextLine();
                System.out.println();
            }

        }

        while (choice != 0);

    }

    private static void addTask(Scanner sc) {
        System.out.println("Enter task: ");
        String description = sc.nextLine();

        tasks.add(new Task(description));
        System.out.println("Task added successfully!");
        System.out.println();
    }

    private static void viewTasks() {
        if (tasks.size() == 0) {
            System.out.println("There is no tasks entered yet");
            System.out.println();
        }

        else {
            System.out.println("To Do List: ");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + 1 + "- " + tasks.get(i));
            }
            System.out.println();
        }
    }

    private static void markTaskDone(Scanner sc) {
        viewTasks();
        if (tasks.isEmpty())
            return;

        System.out.println("Enter task number to mark done: ");
        int taskNum = sc.nextInt();
        sc.nextLine();

        while (true) {

            if (taskNum > 0 && taskNum <= tasks.size()) {
                tasks.get(taskNum - 1).isDone = true;
                System.out.println("Task marked done successfully");
                System.out.println();
                break;
            } else {
                System.out.println("invalid task number, please try again");
                taskNum = sc.nextInt();
                sc.nextLine();
            }
        }

    }

    private static void deleteTask(Scanner sc) {
        viewTasks();
        if (tasks.isEmpty())
            return;

        System.out.println("Enter task number to delete: ");
        int taskNum = sc.nextInt();
        sc.nextLine();

        while (true) {
            if (taskNum > 0 && taskNum <= tasks.size()) {
                tasks.remove(taskNum - 1);
                System.out.println("Task deleted successfully");
                System.out.println();
                break;
            } else {
                System.out.println("invalid task number, please try again");
                taskNum = sc.nextInt();
                sc.nextLine();
            }
        }

    }

}
