import java.util.Scanner;

public class TestLogger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Testing Singleton Logger");
        System.out.print("Enter number of messages to log: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 1; i <= count; i++) {
            System.out.print("Enter message " + i + ": ");
            String message = scanner.nextLine();

            // Get the same instance every time
            Logger logger = Logger.getInstance();
            logger.log(message);
        }

        // Verifying if the same instance is used
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        if (logger1 == logger2) {
            System.out.println("Same logger instance used throughout.");
        } else {
            System.out.println("Different instances found! Singleton not working.");
        }

        scanner.close();
    }
}
