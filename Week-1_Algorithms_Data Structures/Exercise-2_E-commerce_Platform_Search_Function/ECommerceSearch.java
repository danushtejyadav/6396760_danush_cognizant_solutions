import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// Product class with required attributes
class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public void display() {
        System.out.println("ID: " + productId + ", Name: " + productName + ", Category: " + category);
    }
}

public class ECommerceSearch {

    // Linear search based on product name
    public static int linearSearch(Product[] products, String targetName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(targetName)) {
                return i;
            }
        }
        return -1;
    }

    // Binary search based on product name (assumes sorted array)
    public static int binarySearch(Product[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = targetName.compareToIgnoreCase(products[mid].productName);

            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = Integer.parseInt(scanner.nextLine());

        Product[] products = new Product[n];

        // Taking product input from user
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for product " + (i + 1) + ":");
            System.out.print("Product ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Product Name: ");
            String name = scanner.nextLine();

            System.out.print("Category: ");
            String category = scanner.nextLine();

            products[i] = new Product(id, name, category);
        }

        System.out.print("\nEnter product name to search: ");
        String searchTerm = scanner.nextLine();

        // Linear Search
        System.out.println("\n--- Linear Search ---");
        int linearIndex = linearSearch(products, searchTerm);
        if (linearIndex != -1) {
            products[linearIndex].display();
        } else {
            System.out.println("Product not found.");
        }

        // Sort products by name before binary search
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        // Binary Search
        System.out.println("\n--- Binary Search ---");
        int binaryIndex = binarySearch(products, searchTerm);
        if (binaryIndex != -1) {
            products[binaryIndex].display();
        } else {
            System.out.println("Product not found.");
        }

        scanner.close();
    }
}
