import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObserverPatternExample {

    // Step 1: Subject Interface
    interface Stock {
        void registerObserver(Observer observer);
        void removeObserver(Observer observer);
        void notifyObservers();
    }

    // Step 2: Observer Interface
    interface Observer {
        void update(String stockName, double price);
    }

    // Step 3: Concrete Subject
    static class StockMarket implements Stock {
        private List<Observer> observers = new ArrayList<>();
        private String stockName;
        private double stockPrice;

        public void setStockData(String stockName, double stockPrice) {
            this.stockName = stockName;
            this.stockPrice = stockPrice;
            notifyObservers();
        }

        public void registerObserver(Observer observer) {
            observers.add(observer);
            System.out.println(observer.getClass().getSimpleName() + " registered.");
        }

        public void removeObserver(Observer observer) {
            observers.remove(observer);
            System.out.println(observer.getClass().getSimpleName() + " removed.");
        }

        public void notifyObservers() {
            for (Observer o : observers) {
                o.update(stockName, stockPrice);
            }
        }
    }

    // Step 4: Concrete Observers
    static class MobileApp implements Observer {
        public void update(String stockName, double price) {
            System.out.println("📱 Mobile App - " + stockName + " updated to ₹" + price);
        }
    }

    static class WebApp implements Observer {
        public void update(String stockName, double price) {
            System.out.println("💻 Web App - " + stockName + " updated to ₹" + price);
        }
    }

    // Step 5: Main method for testing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StockMarket market = new StockMarket();
        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        System.out.println("=== Stock Market Monitoring System ===");

        // Let user choose which observers to register
        System.out.print("Register Mobile App? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            market.registerObserver(mobile);
        }

        System.out.print("Register Web App? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            market.registerObserver(web);
        }

        while (true) {
            System.out.print("\nEnter stock name (or 'exit' to quit): ");
            String stock = scanner.nextLine();
            if (stock.equalsIgnoreCase("exit")) break;

            System.out.print("Enter new price: ₹");
            double price = scanner.nextDouble();
            scanner.nextLine(); // consume leftover newline

            market.setStockData(stock, price);
        }

        scanner.close();
        System.out.println("Stock monitoring ended.");
    }
}
