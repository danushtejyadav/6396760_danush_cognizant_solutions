import java.util.Scanner;

public class BuilderPatternExample {

    // Step 1: Product class
    static class Computer {
        // Required and optional parts
        private String CPU;
        private String RAM;
        private String storage;
        private String graphicsCard;
        private String operatingSystem;

        // Private constructor
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
            this.graphicsCard = builder.graphicsCard;
            this.operatingSystem = builder.operatingSystem;
        }

        // Display the configuration
        public void displayConfig() {
            System.out.println("\nComputer Configuration:");
            System.out.println("CPU: " + CPU);
            System.out.println("RAM: " + RAM);
            System.out.println("Storage: " + storage);
            System.out.println("Graphics Card: " + graphicsCard);
            System.out.println("Operating System: " + operatingSystem);
        }

        // Step 2: Builder static nested class
        static class Builder {
            private String CPU;
            private String RAM;
            private String storage;
            private String graphicsCard;
            private String operatingSystem;

            public Builder setCPU(String CPU) {
                this.CPU = CPU;
                return this;
            }

            public Builder setRAM(String RAM) {
                this.RAM = RAM;
                return this;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGraphicsCard(String graphicsCard) {
                this.graphicsCard = graphicsCard;
                return this;
            }

            public Builder setOperatingSystem(String operatingSystem) {
                this.operatingSystem = operatingSystem;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }
    }

    // Step 3: Main method with user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Computer.Builder builder = new Computer.Builder();

        System.out.println("Welcome to the Computer Builder!");

        System.out.print("Enter CPU : ");
        builder.setCPU(scanner.nextLine());

        System.out.print("Enter RAM ): ");
        builder.setRAM(scanner.nextLine());

        System.out.print("Enter Storage : ");
        builder.setStorage(scanner.nextLine());

        System.out.print("Enter Graphics Card : ");
        builder.setGraphicsCard(scanner.nextLine());

        System.out.print("Enter Operating System : ");
        builder.setOperatingSystem(scanner.nextLine());

        // Build and display the computer
        Computer myComputer = builder.build();
        myComputer.displayConfig();

        scanner.close();
    }
}
