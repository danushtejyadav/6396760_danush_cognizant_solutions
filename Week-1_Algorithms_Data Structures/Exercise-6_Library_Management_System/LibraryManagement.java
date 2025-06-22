import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// Book class to represent a book
class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public void display() {
        System.out.println("ID: " + bookId + ", Title: " + title + ", Author: " + author);
    }
}

public class LibraryManagement {

    // Linear search: check each element one by one
    public static int linearSearch(Book[] books, String title) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    // Binary search: divide and conquer, only works on sorted list
    public static int binarySearch(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = title.compareToIgnoreCase(books[mid].title);

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

        // Take number of books
        System.out.print("Enter number of books: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Book[] books = new Book[n];

        // Input book details
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for book " + (i + 1) + ":");
            System.out.print("Book ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Title: ");
            String title = scanner.nextLine();

            System.out.print("Author: ");
            String author = scanner.nextLine();

            books[i] = new Book(id, title, author);
        }

        // Take book title to search
        System.out.print("\nEnter book title to search: ");
        String searchTitle = scanner.nextLine();

        // --- Linear Search ---
        System.out.println("\n--- Linear Search ---");
        int linearIndex = linearSearch(books, searchTitle);
        if (linearIndex != -1) {
            books[linearIndex].display();
        } else {
            System.out.println("Book not found.");
        }

        // Sort array before binary search
        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));

        // --- Binary Search ---
        System.out.println("\n--- Binary Search ---");
        int binaryIndex = binarySearch(books, searchTitle);
        if (binaryIndex != -1) {
            books[binaryIndex].display();
        } else {
            System.out.println("Book not found.");
        }

        scanner.close();

        // --- Analysis ---
        System.out.println("\n--- Analysis ---");
        System.out.println("Linear Search Time Complexity: O(n)");
        System.out.println("Binary Search Time Complexity: O(log n)");
        System.out.println("Linear search is better for small or unsorted data.");
        System.out.println("Binary search is faster but needs sorted data.");
    }
}
