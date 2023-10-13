import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class BankAccount {
    private int accountNumber;
    private int accountType;
    private double balance;
    private int customerID; // Add a customer ID field
    private List<String> activityLog;

    public BankAccount(int accountType, double initialBalance, int customerID) {
        this.accountNumber = generateRandomAccountNumber();
        this.accountType = accountType;
        this.balance = initialBalance;
        this.customerID = customerID; // Set the customer's ID
        this.activityLog = new ArrayList<>();
    }

    public int getCustomerID() {
        return customerID; // Getter for customerID
    }

    private int generateRandomAccountNumber() {
        Random rand = new Random();
        return rand.nextInt(9000) + 1000; // Generate a random 4-digit account number
    }

    public void updateAccount(int newAccountType, double newBalance) {
        this.accountType = newAccountType;
        this.balance = newBalance;
        addActivity("Account details updated.");
    }

    public void addActivity(String activity) {
        activityLog.add(activity);
    }

    public void printAccountActivities() {
        for (String activity : activityLog) {
            System.out.println(activity);
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addActivity("Deposit: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addActivity("Withdrawal: " + amount);
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }

    public int getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
