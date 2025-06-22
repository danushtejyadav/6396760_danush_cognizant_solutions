import java.util.Scanner;

public class AdapterPatternExample {

    // Step 1: Target Interface
    interface PaymentProcessor {
        void processPayment(double amount);
    }

    // Step 2: Adaptee classes (existing 3rd-party gateways with different method names)

    // PayPal gateway
    static class PayPalGateway {
        public void sendMoney(double amount) {
            System.out.println("Payment of ₹" + amount + " processed via PayPal.");
        }
    }

    // Stripe gateway
    static class StripeGateway {
        public void makePayment(double amount) {
            System.out.println("Payment of ₹" + amount + " processed via Stripe.");
        }
    }

    // Razorpay gateway
    static class RazorpayGateway {
        public void doTransaction(double amount) {
            System.out.println("Payment of ₹" + amount + " processed via Razorpay.");
        }
    }

    // Step 3: Adapter classes (make them all follow PaymentProcessor interface)

    static class PayPalAdapter implements PaymentProcessor {
        private PayPalGateway payPal;

        public PayPalAdapter() {
            this.payPal = new PayPalGateway();
        }

        public void processPayment(double amount) {
            payPal.sendMoney(amount);
        }
    }

    static class StripeAdapter implements PaymentProcessor {
        private StripeGateway stripe;

        public StripeAdapter() {
            this.stripe = new StripeGateway();
        }

        public void processPayment(double amount) {
            stripe.makePayment(amount);
        }
    }

    static class RazorpayAdapter implements PaymentProcessor {
        private RazorpayGateway razorpay;

        public RazorpayAdapter() {
            this.razorpay = new RazorpayGateway();
        }

        public void processPayment(double amount) {
            razorpay.doTransaction(amount);
        }
    }

    // Step 4: Main method to test adapters with user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Payment System");
        System.out.println("Choose a payment gateway:");
        System.out.println("1. PayPal");
        System.out.println("2. Stripe");
        System.out.println("3. Razorpay");

        System.out.print("Enter your choice (1-3): ");
        int choice = scanner.nextInt();

        System.out.print("Enter amount to pay: ₹");
        double amount = scanner.nextDouble();

        PaymentProcessor processor;

        switch (choice) {
            case 1:
                processor = new PayPalAdapter();
                break;
            case 2:
                processor = new StripeAdapter();
                break;
            case 3:
                processor = new RazorpayAdapter();
                break;
            default:
                System.out.println("Invalid choice!");
                scanner.close();
                return;
        }

        processor.processPayment(amount);
        scanner.close();
    }
}
