import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DependencyInjectionExample {

    // Step 1: Repository Interface
    interface CustomerRepository {
        String findCustomerById(String id);
    }

    // Step 2: Concrete Repository Implementation
    static class CustomerRepositoryImpl implements CustomerRepository {
        private Map<String, String> customerData;

        public CustomerRepositoryImpl() {
            // Simulated database using a HashMap
            customerData = new HashMap<>();
            customerData.put("C101", "Alice");
            customerData.put("C102", "Bob");
            customerData.put("C103", "Charlie");
        }

        public String findCustomerById(String id) {
            return customerData.get(id);
        }
    }

    // Step 3: Service Class that depends on CustomerRepository
    static class CustomerService {
        private CustomerRepository repository;

        // Step 4: Constructor Injection
        public CustomerService(CustomerRepository repository) {
            this.repository = repository;
        }

        public void getCustomer(String id) {
            String name = repository.findCustomerById(id);
            if (name != null) {
                System.out.println("Customer Found: " + name);
            } else {
                System.out.println("Customer not found with ID: " + id);
            }
        }
    }

    // Step 5: Main Method to Test the DI Setup
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating the repository
        CustomerRepository repo = new CustomerRepositoryImpl();

        // Injecting repository into the service
        CustomerService service = new CustomerService(repo);

        System.out.println("=== Customer Management System ===");
        while (true) {
            System.out.print("\nEnter Customer ID to find (or type 'exit'): ");
            String id = scanner.nextLine();

            if (id.equalsIgnoreCase("exit")) break;

            service.getCustomer(id);
        }

        scanner.close();
        System.out.println("Thank you for using the system!");
    }
}
