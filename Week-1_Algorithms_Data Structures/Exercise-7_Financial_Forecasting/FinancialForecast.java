import java.util.Scanner;

public class FinancialForecast {

    // Recursive method to calculate (1 + rate)^years
    public static double calculateGrowth(double rate, int years) {
        if (years == 0) {
            return 1;  // Base case: anything to the power of 0 is 1
        } else {
            return (1 + rate) * calculateGrowth(rate, years - 1);
        }
    }

    // Future Value = Present Value * (1 + rate)^years
    public static double predictFutureValue(double presentValue, double rate, int years) {
        return presentValue * calculateGrowth(rate, years);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input
        System.out.print("Enter present value (amount): ");
        double presentValue = scanner.nextDouble();

        System.out.print("Enter annual growth rate (in %): ");
        double ratePercent = scanner.nextDouble();
        double rate = ratePercent / 100;  // Convert to decimal

        System.out.print("Enter number of years: ");
        int years = scanner.nextInt();

        // Predict future value using recursion
        double futureValue = predictFutureValue(presentValue, rate, years);
        System.out.printf("Predicted future value after %d years: %.2f\n", years, futureValue);

        // Time complexity analysis
        System.out.println("\n--- Analysis ---");


        scanner.close();
    }
}
