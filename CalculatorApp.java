// CalculatorApp.java
import java.util.InputMismatchException;
import java.util.Scanner;

// ---------------- Calculator Class ----------------
class Calculator {

    // Overloaded Addition Methods
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Subtraction Method
    public int subtract(int a, int b) {
        return a - b;
    }

    // Multiplication Method
    public double multiply(double a, double b) {
        return a * b;
    }

    // Division Method with Exception Handling
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Error: Cannot divide by zero!");
        }
        return (double) a / b;
    }
}

// ---------------- User Interface Class ----------------
public class CalculatorApp {

    private static Scanner scanner = new Scanner(System.in);
    private static Calculator calc = new Calculator();

    // Perform Addition
    public static void performAddition() {
        try {
            System.out.println("\nChoose Addition Type:");
            System.out.println("1. Add two integers");
            System.out.println("2. Add two doubles");
            System.out.println("3. Add three integers");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter first integer: ");
                    int a = scanner.nextInt();
                    System.out.print("Enter second integer: ");
                    int b = scanner.nextInt();
                    System.out.println("Result: " + calc.add(a, b));
                }
                case 2 -> {
                    System.out.print("Enter first double: ");
                    double x = scanner.nextDouble();
                    System.out.print("Enter second double: ");
                    double y = scanner.nextDouble();
                    System.out.println("Result: " + calc.add(x, y));
                }
                case 3 -> {
                    System.out.print("Enter first integer: ");
                    int p = scanner.nextInt();
                    System.out.print("Enter second integer: ");
                    int q = scanner.nextInt();
                    System.out.print("Enter third integer: ");
                    int r = scanner.nextInt();
                    System.out.println("Result: " + calc.add(p, q, r));
                }
                default -> System.out.println("Invalid choice for addition.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter valid numbers.");
            scanner.nextLine(); // clear invalid input
        }
    }

    // Perform Subtraction
    public static void performSubtraction() {
        try {
            System.out.print("Enter first integer: ");
            int a = scanner.nextInt();
            System.out.print("Enter second integer: ");
            int b = scanner.nextInt();
            System.out.println("Result: " + calc.subtract(a, b));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter valid integers.");
            scanner.nextLine();
        }
    }

    // Perform Multiplication
    public static void performMultiplication() {
        try {
            System.out.print("Enter first double: ");
            double a = scanner.nextDouble();
            System.out.print("Enter second double: ");
            double b = scanner.nextDouble();
            System.out.println("Result: " + calc.multiply(a, b));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter valid doubles.");
            scanner.nextLine();
        }
    }

    // Perform Division
    public static void performDivision() {
        try {
            System.out.print("Enter numerator (integer): ");
            int a = scanner.nextInt();
            System.out.print("Enter denominator (integer): ");
            int b = scanner.nextInt();
            System.out.println("Result: " + calc.divide(a, b));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter valid integers.");
            scanner.nextLine();
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    // Main Menu
    public static void mainMenu() {
        int choice;
        do {
            System.out.println("\n=== Calculator Application ===");
            System.out.println("1. Add Numbers");
            System.out.println("2. Subtract Numbers");
            System.out.println("3. Multiply Numbers");
            System.out.println("4. Divide Numbers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> performAddition();
                    case 2 -> performSubtraction();
                    case 3 -> performMultiplication();
                    case 4 -> performDivision();
                    case 5 -> System.out.println("Exiting... Thank you!");
                    default -> System.out.println("Invalid choice! Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid choice.");
                scanner.nextLine();
                choice = 0;
            }
        } while (choice != 5);
    }

    // Main Method
    public static void main(String[] args) {
        System.out.println("Welcome to the Calculator Application!");
        mainMenu();
    }
}
