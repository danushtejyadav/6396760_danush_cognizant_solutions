import java.util.Scanner;

public class FactoryMethodExample {

    // Step 1: Document interface
    interface Document {
        void open();
    }

    // Step 2: Concrete Document classes
    static class WordDocument implements Document {
        public void open() {
            System.out.println("Opening Word Document...");
        }
    }

    static class PdfDocument implements Document {
        public void open() {
            System.out.println("Opening PDF Document...");
        }
    }

    static class ExcelDocument implements Document {
        public void open() {
            System.out.println("Opening Excel Document...");
        }
    }

    // Step 3: DocumentFactory abstract class
    static abstract class DocumentFactory {
        public abstract Document createDocument();
    }

    // Step 4: Concrete factories
    static class WordDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new WordDocument();
        }
    }

    static class PdfDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    static class ExcelDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new ExcelDocument();
        }
    }

    // Step 5: Main method to test
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Document Creator - Factory Method Pattern");
        System.out.println("1. Word Document");
        System.out.println("2. PDF Document");
        System.out.println("3. Excel Document");

        System.out.print("Enter your choice (1-3): ");
        int choice = scanner.nextInt();

        DocumentFactory factory = null;

        switch (choice) {
            case 1:
                factory = new WordDocumentFactory();
                break;
            case 2:
                factory = new PdfDocumentFactory();
                break;
            case 3:
                factory = new ExcelDocumentFactory();
                break;
            default:
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                scanner.close();
                return;
        }

        Document document = factory.createDocument();
        document.open();

        scanner.close();
    }
}
