import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Class to represent a product
class Product {
   int productId;
   String productName;
   int quantity;
   double price;

   public Product(int productId, String productName, int quantity, double price) {
       this.productId = productId;
       this.productName = productName;
       this.quantity = quantity;
       this.price = price;
   }

   public void displayProduct() {
       System.out.println("ID: " + productId + ", Name: " + productName +
               ", Quantity: " + quantity + ", Price: " + price);
   }
}

// Main class for managing inventory
public class InventoryManager {
   private Map<Integer, Product> inventory;

   public InventoryManager() {
       inventory = new HashMap<>();
   }

   // Add product to inventory
   public void addProduct(Product product) {
       if (inventory.containsKey(product.productId)) {
           System.out.println("Product already exists with this ID.");
       } else {
           inventory.put(product.productId, product);
           System.out.println("Product added successfully.");
       }
   }

   // Update existing product
   public void updateProduct(int productId, String name, int quantity, double price) {
       Product product = inventory.get(productId);
       if (product != null) {
           product.productName = name;
           product.quantity = quantity;
           product.price = price;
           System.out.println("Product updated successfully.");
       } else {
           System.out.println("Product not found.");
       }
   }

   // Delete a product
   public void deleteProduct(int productId) {
       if (inventory.remove(productId) != null) {
           System.out.println("Product deleted.");
       } else {
           System.out.println("Product not found.");
       }
   }

   // Display all products
   public void displayAllProducts() {
       if (inventory.isEmpty()) {
           System.out.println("No products in the inventory.");
       } else {
           for (Product p : inventory.values()) {
               p.displayProduct();
           }
       }
   }

   // Main method to handle user input
   public static void main(String[] args) {
       InventoryManager manager = new InventoryManager();
       Scanner scanner = new Scanner(System.in);

       System.out.println("Welcome to Inventory Management System");

       while (true) {
           System.out.println("\nMenu:");
           System.out.println("1. Add Product");
           System.out.println("2. Update Product");
           System.out.println("3. Delete Product");
           System.out.println("4. Display All Products");
           System.out.println("5. Exit");
           System.out.print("Enter your choice: ");

           int choice = scanner.nextInt();
           scanner.nextLine(); // consume newline

           switch (choice) {
               case 1:
                   System.out.print("Enter Product ID: ");
                   int id = scanner.nextInt();
                   scanner.nextLine();

                   System.out.print("Enter Product Name: ");
                   String name = scanner.nextLine();

                   System.out.print("Enter Quantity: ");
                   int qty = scanner.nextInt();

                   System.out.print("Enter Price: ");
                   double price = scanner.nextDouble();

                   Product product = new Product(id, name, qty, price);
                   manager.addProduct(product);
                   break;

               case 2:
                   System.out.print("Enter Product ID to update: ");
                   int updateId = scanner.nextInt();
                   scanner.nextLine();

                   System.out.print("Enter New Name: ");
                   String newName = scanner.nextLine();

                   System.out.print("Enter New Quantity: ");
                   int newQty = scanner.nextInt();

                   System.out.print("Enter New Price: ");
                   double newPrice = scanner.nextDouble();

                   manager.updateProduct(updateId, newName, newQty, newPrice);
                   break;

               case 3:
                   System.out.print("Enter Product ID to delete: ");
                   int delId = scanner.nextInt();
                   manager.deleteProduct(delId);
                   break;

               case 4:
                   manager.displayAllProducts();
                   break;

               case 5:
                   System.out.println("Exiting program.");
                   scanner.close();
                   return;

               default:
                   System.out.println("Invalid choice. Please try again.");
           }
       }
   }
}
