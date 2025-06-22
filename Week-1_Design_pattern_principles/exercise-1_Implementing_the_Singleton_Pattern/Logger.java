public class Logger {
    // Step 1: Create a private static instance
    private static Logger singleInstance;

    // Step 2: Make constructor private so no other class can create instance
    private Logger() {
        System.out.println("Logger initialized.");
    }

    // Step 3: Provide a public method to return the same instance
    public static Logger getInstance() {
        if (singleInstance == null) {
            singleInstance = new Logger(); // create only if it doesn't exist
        }
        return singleInstance;
    }

    // Step 4: A method to log messages
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
