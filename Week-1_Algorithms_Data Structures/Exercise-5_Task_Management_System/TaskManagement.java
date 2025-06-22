import java.util.Scanner;

// Node class with task information
class Task {
    int taskId;
    String taskName;
    String status;
    Task next; // Pointer to next node

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    public void display() {
        System.out.println("ID: " + taskId + ", Name: " + taskName + ", Status: " + status);
    }
}

public class TaskManagement {

    // Head of the linked list
    static Task head = null;

    // Add task at end
    public static void addTask(Task newTask) {
        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }
        System.out.println("Task added successfully.");
    }

    // Search task by ID
    public static void searchTask(int id) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id) {
                temp.display();
                return;
            }
            temp = temp.next;
        }
        System.out.println("Task not found.");
    }

    // Display all tasks
    public static void displayTasks() {
        if (head == null) {
            System.out.println("No tasks found.");
            return;
        }

        Task temp = head;
        while (temp != null) {
            temp.display();
            temp = temp.next;
        }
    }

    // Delete task by ID
    public static void deleteTask(int id) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // If first node is to be deleted
        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task deleted successfully.");
            return;
        }

        // Search and delete
        Task temp = head;
        while (temp.next != null) {
            if (temp.next.taskId == id) {
                temp.next = temp.next.next;
                System.out.println("Task deleted successfully.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Task not found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Menu loop
        do {
            System.out.println("\n--- Task Management Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task by ID");
            System.out.println("3. Display All Tasks");
            System.out.println("4. Delete Task by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Task Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Task Status (Pending/Completed): ");
                    String status = scanner.nextLine();

                    Task t = new Task(id, name, status);
                    addTask(t);
                    break;

                case 2:
                    System.out.print("Enter Task ID to search: ");
                    int searchId = scanner.nextInt();
                    searchTask(searchId);
                    break;

                case 3:
                    displayTasks();
                    break;

                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    deleteTask(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting Task Manager.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
