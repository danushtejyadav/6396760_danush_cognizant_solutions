import java.util.Scanner;

public class CommandPatternExample {

    // Step 1: Command Interface
    interface Command {
        void execute();
    }

    // Step 2: Receiver Class (the actual device)
    static class Light {
        public void turnOn() {
            System.out.println("The light is ON.");
        }

        public void turnOff() {
            System.out.println("The light is OFF.");
        }
    }

    // Step 3: Concrete Commands
    static class LightOnCommand implements Command {
        private Light light;

        public LightOnCommand(Light light) {
            this.light = light;
        }

        public void execute() {
            light.turnOn();
        }
    }

    static class LightOffCommand implements Command {
        private Light light;

        public LightOffCommand(Light light) {
            this.light = light;
        }

        public void execute() {
            light.turnOff();
        }
    }

    // Step 4: Invoker Class (e.g., a remote control)
    static class RemoteControl {
        private Command command;

        public void setCommand(Command command) {
            this.command = command;
        }

        public void pressButton() {
            if (command != null) {
                command.execute();
            } else {
                System.out.println("No command set.");
            }
        }
    }

    // Step 5: Main method to test the pattern
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Light livingRoomLight = new Light();

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        System.out.println("=== Home Automation: Light Control ===");
        System.out.println("Commands:");
        System.out.println("1. Turn ON the light");
        System.out.println("2. Turn OFF the light");
        System.out.println("3. Exit");

        while (true) {
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    remote.setCommand(lightOn);
                    remote.pressButton();
                    break;
                case 2:
                    remote.setCommand(lightOff);
                    remote.pressButton();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
