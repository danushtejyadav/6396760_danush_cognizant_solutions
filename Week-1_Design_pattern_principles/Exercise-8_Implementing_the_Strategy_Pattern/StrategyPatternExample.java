import java.util.Scanner;

public class StrategyPatternExample {

    // Step 1: Strategy Interface
    interface PaymentStrategy {
        void pay(double amount);
    }

    // Step 2: Concrete Strategy - Credit Card
    static class CreditCardPayment implements PaymentStrategy {
        private String cardNumber;
        private String cardHolder;

        public CreditCardPayment(String cardNumber, String cardHolder) {
            this.cardNumber = cardNumber;
            this.cardHolder = cardHolder;
        }

        public void pay(double amount) {
            System.out.println("Paying ₹" + amount + " using Credit Card (" + cardHolder + ").");
        }
    }

    // Step 3: Concrete Strategy - PayPal
    static class PayPalPayment implements PaymentStrategy {
        private String email;

        public PayPalPayment(String email) {
            this.email = email;
        }

        public void pay(double amount) {
            System.out.println("Paying ₹" + amount + " using PayPal account (" + email + ").");
        }
    }

    // Step 4: Context Class
    static class PaymentContext {
        private PaymentStrategy strategy;

        public void setPaymentStrategy(PaymentStrategy strategy) {
            this.strategy = strategy;
        }

        public void executePayment(double amount) {
            if (strategy != null) {
                strategy.pay(amount);
            } else {
                System.out.println("No payment method selected.");
            }
        }
    }

    // Step 5: Test with user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentContext context = new PaymentContext();

        System.out.println("=== Payment System ===");
        System.out.print("Enter amount to pay: ₹");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        System.out.println("Choose payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter card number: ");
                String cardNumber = scanner.nextLine();
                System.out.print("Enter card holder name: ");
                String cardHolder = scanner.nextLine();
                context.setPaymentStrategy(new CreditCardPayment(cardNumber, cardHolder));
                break;

            case 2:
                System.out.print("Enter PayPal email: ");
                String email = scanner.nextLine();
                context.setPaymentStrategy(new PayPalPayment(email));
                break;

            default:
                System.out.println("Invalid payment method.");
                scanner.close();
                return;
        }

        context.executePayment(amount);
        scanner.close();
    }
}
