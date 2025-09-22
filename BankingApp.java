import java.util.Scanner;

//Account class for details of account.
class Account {
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private String email;
    private String phoneNumber;

    // Constructor
    public Account(int accountNumber, String accountHolderName, double balance, String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount. Must be positive.");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount. Must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining Balance: " + balance);
        }
    }

    // Display account details
    public void displayAccountDetails() {
        System.out.println("------- Account Details -------");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("--------------------------------");
    }

    // Update contact details
    public void updateContactDetails(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        System.out.println("Contact details updated successfully!");
    }

    // Getter
    public int getAccountNumber() {
        return accountNumber;
    }
}

//Class UserInterface (Details which are user shows).
class UserInterface {
    private Account[] accounts;
    private int accountCount;
    private Scanner scanner;
    private int accountNumberGenerator = 10000001;

    // Constructor
    public UserInterface(int maxAccounts) {
        accounts = new Account[maxAccounts];
        accountCount = 0;
        scanner = new Scanner(System.in);
    }

    // Create new account
    public void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();

        System.out.print("Enter initial deposit amount: ");
        double amount = readDoubleInput();

        System.out.print("Enter email address: ");
        String email = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        Account newAccount = new Account(accountNumberGenerator++, name, amount, email, phone);
        accounts[accountCount++] = newAccount;

        System.out.println("Account created successfully with Account Number: " + newAccount.getAccountNumber());
    }

    // Deposit
    public void performDeposit() {
        Account acc = findAccount();
        if (acc != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = readDoubleInput();
            acc.deposit(amount);
        }
    }

    // Withdraw
    public void performWithdrawal() {
        Account acc = findAccount();
        if (acc != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = readDoubleInput();
            acc.withdraw(amount);
        }
    }

    // Show details
    public void showAccountDetails() {
        Account acc = findAccount();
        if (acc != null) {
            acc.displayAccountDetails();
        }
    }

    // Update contact
    public void updateContact() {
        Account acc = findAccount();
        if (acc != null) {
            System.out.print("Enter new email: ");
            String email = scanner.nextLine();
            System.out.print("Enter new phone number: ");
            String phone = scanner.nextLine();
            acc.updateContactDetails(email, phone);
        }
    }

    // Find account by account number
    private Account findAccount() {
        System.out.print("Enter account number: ");
        int accNum = readIntInput();

        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accNum) {
                return accounts[i];
            }
        }
        System.out.println("Account not found!");
        return null;
    }

    // Safe integer input
    private int readIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a valid number: ");
            }
        }
    }

    // Safe double input
    private double readDoubleInput() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a valid amount: ");
            }
        }
    }

    // Main menu
    public void mainMenu() {
        while (true) {
            System.out.println("\n=== Banking Application ===");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View account details");
            System.out.println("5. Update contact details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = readIntInput();

            switch (choice) {
                case 1: createAccount(); break;
                case 2: performDeposit(); break;
                case 3: performWithdrawal(); break;
                case 4: showAccountDetails(); break;
                case 5: updateContact(); break;
                case 6:
                    System.out.println("Thank you for using the Banking Application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

//Main Class (To execute the code).
public class BankingApp {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface(500);
        ui.mainMenu();
    }
}
