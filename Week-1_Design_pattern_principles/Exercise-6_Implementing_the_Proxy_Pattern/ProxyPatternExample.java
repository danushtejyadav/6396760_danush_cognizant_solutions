import java.util.HashMap;
import java.util.Scanner;

public class ProxyPatternExample {

    // Step 1: Subject Interface
    interface Image {
        void display();
    }

    // Step 2: Real Subject Class (Simulate loading from remote server)
    static class RealImage implements Image {
        private String fileName;

        public RealImage(String fileName) {
            this.fileName = fileName;
            loadFromServer();
        }

        private void loadFromServer() {
            System.out.println("Loading image from remote server: " + fileName);
            // Simulate delay
            try {
                Thread.sleep(1000); // 1 second delay to simulate loading
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void display() {
            System.out.println("Displaying image: " + fileName);
        }
    }

    // Step 3: Proxy Class with lazy loading and caching
    static class ProxyImage implements Image {
        private String fileName;
        private RealImage realImage;

        public ProxyImage(String fileName) {
            this.fileName = fileName;
        }

        public void display() {
            if (realImage == null) {
                realImage = new RealImage(fileName);
            } else {
                System.out.println("Loaded from cache: " + fileName);
            }
            realImage.display();
        }
    }

    // Step 4: Main class to test the proxy
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Image> imageMap = new HashMap<>();

        System.out.println("Welcome to Image Viewer (Proxy Pattern)");
        System.out.println("Type 'exit' to quit.");

        while (true) {
            System.out.print("\nEnter image name to view (e.g., photo1.jpg): ");
            String fileName = scanner.nextLine();

            if (fileName.equalsIgnoreCase("exit")) {
                break;
            }

            // Get from map or create a new proxy
            Image image = imageMap.getOrDefault(fileName, new ProxyImage(fileName));
            image.display();
            imageMap.putIfAbsent(fileName, image);
        }

        scanner.close();
        System.out.println("\nThank you for using the image viewer!");
    }
}
