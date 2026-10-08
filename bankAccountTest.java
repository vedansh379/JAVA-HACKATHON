import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Parameterized constructor
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Method to deposit amount
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw amount
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: " + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to return current balance
    public double checkBalance() {
        return balance;
    }

    // Method to display account details
    public void displayAccount() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Current Balance: " + balance);
    }
}

public class bankAccountTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read initial account details
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String accHolder = scanner.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initialBalance = scanner.nextDouble();

        // Create BankAccount object using parameterized constructor
        BankAccount account = new BankAccount(accNum, accHolder, initialBalance);

        // Perform one deposit operation
        System.out.print("\nEnter Deposit Amount: ");
        double depositAmount = scanner.nextDouble();
        account.deposit(depositAmount);

        // Perform one withdrawal operation
        System.out.print("Enter Withdrawal Amount: ");
        double withdrawAmount = scanner.nextDouble();
        account.withdraw(withdrawAmount);

        // Display final account details
        account.displayAccount();

        scanner.close();
    }
}