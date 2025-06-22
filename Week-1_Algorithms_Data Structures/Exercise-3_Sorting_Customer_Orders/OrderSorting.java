import java.util.Scanner;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public void display() {
        System.out.println("Order ID: " + orderId + ", Customer: " + customerName + ", Total Price: " + totalPrice);
    }
}

public class OrderSorting {

    // Bubble Sort: simple but slow for large data - O(n^2)
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    // Swap
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort: fast and efficient - Avg O(n log n)
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);

            quickSort(orders, low, pi - 1);  // Left of pivot
            quickSort(orders, pi + 1, high); // Right of pivot
        }
    }

    public static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                // Swap
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        // Swap pivot to correct position
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    // Function to display all orders
    public static void displayOrders(Order[] orders) {
        for (Order order : orders) {
            order.display();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: number of orders
        System.out.print("Enter number of customer orders: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Order[] orders = new Order[n];

        // Input: order details
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for order " + (i + 1) + ":");
            System.out.print("Order ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Customer Name: ");
            String name = scanner.nextLine();

            System.out.print("Total Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            orders[i] = new Order(id, name, price);
        }

        // Bubble Sort
        System.out.println("\n--- Bubble Sort by Total Price ---");
        Order[] bubbleSorted = orders.clone();
        bubbleSort(bubbleSorted);
        displayOrders(bubbleSorted);

        // Quick Sort
        System.out.println("\n--- Quick Sort by Total Price ---");
        Order[] quickSorted = orders.clone();
        quickSort(quickSorted, 0, quickSorted.length - 1);
        displayOrders(quickSorted);

        scanner.close();

        // Analysis:
        System.out.println("\n--- Analysis ---");
        System.out.println("Bubble Sort Time Complexity: O(n^2) - Not efficient for large data");
        System.out.println("Quick Sort Time Complexity: O(n log n) on average - Much faster and preferred");
    }
}
