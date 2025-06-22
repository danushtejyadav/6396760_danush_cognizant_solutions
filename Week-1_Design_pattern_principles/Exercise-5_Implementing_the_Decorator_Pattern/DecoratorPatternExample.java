import java.util.Scanner;

public class DecoratorPatternExample {

    // Step 1: Component Interface
    interface Notifier {
        void send(String message);
    }

    // Step 2: Concrete Component
    static class EmailNotifier implements Notifier {
        public void send(String message) {
            System.out.println("Sending Email: " + message);
        }
    }

    // Step 3: Abstract Decorator
    static abstract class NotifierDecorator implements Notifier {
        protected Notifier wrappedNotifier;

        public NotifierDecorator(Notifier notifier) {
            this.wrappedNotifier = notifier;
        }

        public void send(String message) {
            wrappedNotifier.send(message);
        }
    }

    // Step 4: Concrete Decorators

    static class SMSNotifierDecorator extends NotifierDecorator {
        public SMSNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        public void send(String message) {
            super.send(message);
            System.out.println("Sending SMS: " + message);
        }
    }

    static class SlackNotifierDecorator extends NotifierDecorator {
        public SlackNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        public void send(String message) {
            super.send(message);
            System.out.println("Sending Slack message: " + message);
        }
    }

    // Step 5: Test the decorator with user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Start with basic email notifier
        Notifier notifier = new EmailNotifier();

        System.out.println("=== Notification Channel Selection ===");
        System.out.println("Email is enabled by default.");
        System.out.print("Add SMS? (yes/no): ");
        String sms = scanner.nextLine();

        System.out.print("Add Slack? (yes/no): ");
        String slack = scanner.nextLine();

        System.out.print("Enter the message to send: ");
        String message = scanner.nextLine();

        // Apply decorators based on user choice
        if (sms.equalsIgnoreCase("yes")) {
            notifier = new SMSNotifierDecorator(notifier);
        }

        if (slack.equalsIgnoreCase("yes")) {
            notifier = new SlackNotifierDecorator(notifier);
        }

        // Send the notification
        System.out.println("\nSending notifications...");
        notifier.send(message);

        scanner.close();
    }
}
