import java.util.Scanner;

public class MVCPatternExample {

    // Step 1: Model - Student
    static class Student {
        private String name;
        private String id;
        private String grade;

        // Constructor
        public Student(String name, String id, String grade) {
            this.name = name;
            this.id = id;
            this.grade = grade;
        }

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }
    }

    // Step 2: View - StudentView
    static class StudentView {
        public void displayStudentDetails(String name, String id, String grade) {
            System.out.println("\n=== Student Details ===");
            System.out.println("Name : " + name);
            System.out.println("ID   : " + id);
            System.out.println("Grade: " + grade);
        }
    }

    // Step 3: Controller - StudentController
    static class StudentController {
        private Student model;
        private StudentView view;

        public StudentController(Student model, StudentView view) {
            this.model = model;
            this.view = view;
        }

        public void setStudentName(String name) {
            model.setName(name);
        }

        public void setStudentId(String id) {
            model.setId(id);
        }

        public void setStudentGrade(String grade) {
            model.setGrade(grade);
        }

        public void updateView() {
            view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
        }
    }

    // Step 4: Main method for testing MVC pattern
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Student Records System (MVC) ===");

        // User input to create student
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Student Grade: ");
        String grade = scanner.nextLine();

        // Model + View + Controller
        Student model = new Student(name, id, grade);
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        // Show initial data
        controller.updateView();

        // Ask to update student details
        System.out.println("\nDo you want to update student details? (yes/no): ");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("yes")) {
            System.out.print("Update Name: ");
            controller.setStudentName(scanner.nextLine());

            System.out.print("Update ID: ");
            controller.setStudentId(scanner.nextLine());

            System.out.print("Update Grade: ");
            controller.setStudentGrade(scanner.nextLine());
        }

        // Show updated data
        controller.updateView();

        scanner.close();
    }
}
