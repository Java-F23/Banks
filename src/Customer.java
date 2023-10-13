import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//
//public class Customer {
//    private int id;
//    private String name;
//    private List<BankAccount> bankAccounts;
//    private List<BankAccount> favoriteAccounts;
//
//    private Scanner scanner;
//
//    public Customer(int id, String name) {
//        this.id = id;
//        this.name = name;
//        this.bankAccounts = new ArrayList<>();
//        this.favoriteAccounts = new ArrayList<>();
//        this.scanner = new Scanner(System.in); // Initialize the Scanner for the customer
//    }
//
//    public Scanner getScanner() {
//        return scanner;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void addBankAccount(BankAccount bankAccount) {
//        bankAccounts.add(bankAccount);
//    }
//
//    public List<BankAccount> getAvailableBankAccounts() {
//        return bankAccounts;
//    }
//
//    public List<BankAccount> searchBankAccountsByFilter() {
//        // Implement search functionality based on account type, balance, etc.
//        // Modify this method as needed to match your requirements.
//        // For example:
//        System.out.print("Enter account type (-1 for any): ");
//        int accountType = getScanner().nextInt();
//        System.out.print("Enter minimum balance: ");
//        double minBalance = getScanner().nextDouble();
//        System.out.print("Enter maximum balance: ");
//        double maxBalance = getScanner().nextDouble();
//
//        List<BankAccount> matchingAccounts = new ArrayList<>();
//        for (BankAccount account : bankAccounts) {
//            if ((accountType == -1 || account.getAccountType() == accountType) &&
//                    (minBalance <= account.getBalance() && account.getBalance() <= maxBalance)) {
//                matchingAccounts.add(account);
//            }
//        }
//        return matchingAccounts;
//    }
//
//    public BankAccount getBankAccountByNumber() {
//        System.out.print("Enter account number: ");
//        int accountNumber = getScanner().nextInt();
//        for (BankAccount account : bankAccounts) {
//            if (account.getAccountNumber() == accountNumber) {
//                return account;
//            }
//        }
//        return null;
//    }
//
//    public void markAccountAsFavorite(BankAccount bankAccount) {
//        favoriteAccounts.add(bankAccount);
//    }
//
//    public List<BankAccount> getFavoriteAccounts() {
//        return favoriteAccounts;
//    }
//
//    public void depositToAccount(BankAccount bankAccount) {
//        System.out.print("Enter the amount to deposit: ");
//        double amount = getScanner().nextDouble();
//        if (bankAccounts.contains(bankAccount)) {
//            bankAccount.deposit(amount);
//        }
//    }
//
//    public void withdrawFromAccount(BankAccount bankAccount) {
//        System.out.print("Enter the amount to withdraw: ");
//        double amount = getScanner().nextDouble();
//        if (bankAccounts.contains(bankAccount)) {
//            bankAccount.withdraw(amount);
//        }
//    }
//
//    public static void displayAvailableAccounts(List<BankAccount> accounts) {
//        for (BankAccount account : accounts) {
//            System.out.println("Account Number: " + account.getAccountNumber());
//            System.out.println("Account Type: " + account.getAccountType());
//            System.out.println("Balance: " + account.getBalance());
//            System.out.println();
//        }
//    }
//
//    public static void displayMatchingAccounts(List<BankAccount> accounts) {
//        if (accounts.isEmpty()) {
//            System.out.println("No matching accounts found.");
//        } else {
//            System.out.println("Matching Accounts:");
//            for (BankAccount account : accounts) {
//                System.out.println("Account Number: " + account.getAccountNumber());
//                System.out.println("Account Type: " + account.getAccountType());
//                System.out.println("Balance: " + account.getBalance());
//                System.out.println();
//            }
//        }
//    }
//
//    public static void viewAccountDetails(BankAccount account) {
//        if (account != null) {
//            System.out.println("Account Number: " + account.getAccountNumber());
//            System.out.println("Account Type: " + account.getAccountType());
//            System.out.println("Balance: " + account.getBalance());
//            System.out.println("Activity Log:");
//            account.printAccountActivities();
//        } else {
//            System.out.println("Account not found.");
//        }
//    }
//
//}

public class Customer {
    private int id;
    private String name;
    private List<BankAccount> bankAccounts;
    private List<BankAccount> favoriteAccounts;

    private Scanner scanner;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
        this.bankAccounts = new ArrayList<>();
        this.favoriteAccounts = new ArrayList<>();
        this.scanner = new Scanner(System.in); // Initialize the Scanner for the customer
    }

    public Scanner getScanner() {
        return scanner;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addBankAccount(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
    }

    public List<BankAccount> getAvailableBankAccounts() {
        List<BankAccount> availableAccounts = new ArrayList<>();
        for (BankAccount account : bankAccounts) {
            if (account.getCustomerID() == this.id) {
                availableAccounts.add(account);
            }
        }
        return availableAccounts;
    }

    public List<BankAccount> searchBankAccountsByFilter() {
        // Implement search functionality based on account type, balance, etc.
        // Modify this method as needed to match your requirements.
        // For example:
        System.out.print("Enter account type (-1 for any): ");
        int accountType = getScanner().nextInt();
        System.out.print("Enter minimum balance: ");
        double minBalance = getScanner().nextDouble();
        System.out.print("Enter maximum balance: ");
        double maxBalance = getScanner().nextDouble();

        List<BankAccount> matchingAccounts = new ArrayList<>();
        for (BankAccount account : bankAccounts) {
            if (account.getCustomerID() == this.id && (accountType == -1 || account.getAccountType() == accountType) &&
                    (minBalance <= account.getBalance() && account.getBalance() <= maxBalance)) {
                matchingAccounts.add(account);
            }
        }
        return matchingAccounts;
    }

    public BankAccount getBankAccountByNumber() {
        System.out.print("Enter account number: ");
        int accountNumber = getScanner().nextInt();
        for (BankAccount account : bankAccounts) {
            if (account.getCustomerID() == this.id && account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public void displayAvailableAccounts(List<BankAccount> accounts) {
        if (accounts.isEmpty()) {
            System.out.println("No available accounts found.");
        } else {
            System.out.println("Available Accounts:");
            for (BankAccount account : accounts) {
                System.out.println("Account Number: " + account.getAccountNumber());
                System.out.println("Account Type: " + account.getAccountType());
                System.out.println("Balance: " + account.getBalance());
                System.out.println();
            }
        }
    }

    public void displayMatchingAccounts(List<BankAccount> accounts) {
        if (accounts.isEmpty()) {
            System.out.println("No matching accounts found.");
        } else {
            System.out.println("Matching Accounts:");
            for (BankAccount account : accounts) {
                System.out.println("Account Number: " + account.getAccountNumber());
                System.out.println("Account Type: " + account.getAccountType());
                System.out.println("Balance: " + account.getBalance());
                System.out.println();
            }
        }
    }

    public void viewAccountDetails(BankAccount account) {
        if (account != null) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Type: " + account.getAccountType());
            System.out.println("Balance: " + account.getBalance());
            System.out.println("Activity Log:");
            account.printAccountActivities();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void markAccountAsFavorite(BankAccount account) {
        if (account != null) {
            markAccountAsFavorite(account);
            System.out.println("Account marked as favorite.");
        } else {
            System.out.println("Account not found.");
        }
    }

    public void depositToAccount(BankAccount account) {
        if (account != null) {
            System.out.print("Enter the amount to deposit: ");
            double amount = getScanner().nextDouble();
            account.deposit(amount);
            System.out.println("Deposit completed.");
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdrawFromAccount(BankAccount account) {
        if (account != null) {
            System.out.print("Enter the amount to withdraw: ");
            double amount = getScanner().nextDouble();
            account.withdraw(amount);
            System.out.println("Withdrawal completed.");
        } else {
            System.out.println("Account not found.");
        }
    }

    // Other methods remain the same
}

