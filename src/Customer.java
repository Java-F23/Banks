import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Customer {
    private int id;
    private String name;
    private List<BankAccount> bankAccounts;
    private List<BankAccount> favoriteAccounts;

    private List<Loan> loanApplications;

    private Scanner scanner;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
        this.bankAccounts = new ArrayList<>();
        this.favoriteAccounts = new ArrayList<>();
        this.scanner = new Scanner(System.in); // Initialize the Scanner for the customer
        loanApplications = new ArrayList<>();
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
        return bankAccounts;
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

    public void displayAccounts(List<BankAccount> accounts) {
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

    public void viewAllRecords() {
        for(BankAccount account : bankAccounts)
        {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Type: " + account.getAccountType());
            System.out.println("Balance: " + account.getBalance());
            System.out.println("Activity Log:");
            account.printAccountActivities();
            System.out.println("\n");
        }
        System.out.println("\n");
    }

    public void viewAccountRecords(BankAccount account) {
        account.printAccountActivities();
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
            favoriteAccounts.add(account);
            System.out.println("Account marked as favorite.");
        } else {
            System.out.println("Account not found.");
        }
    }

    public void depositToAccount(BankAccount account) {
        if (account != null) {
            try {
                System.out.print("Enter the amount to deposit: ");
                double amount = getScanner().nextDouble();
                account.deposit(amount);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid amount.");
                getScanner().nextLine(); // Consume the invalid input
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdrawFromAccount(BankAccount account) {
        if (account != null) {
            try {
                System.out.print("Enter the amount to withdraw: ");
                double amount = getScanner().nextDouble();
                account.withdraw(amount);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid amount.");
                getScanner().nextLine(); // Consume the invalid input
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public List<BankAccount> getFavoriteAccounts()
    {
        return favoriteAccounts;
    }

    public void transferBetweenAccounts() {
        Scanner scanner = getScanner();

        // Prompt the user to enter the source account number
        System.out.print("Enter the source account number: ");
        int sourceAccountNumber = scanner.nextInt();

        // Prompt the user to enter the target account number
        System.out.print("Enter the target account number: ");
        int targetAccountNumber = scanner.nextInt();

        // Find the source and target accounts by their account numbers
        BankAccount sourceAccount = BankAccount.getBankAccountByNumber(bankAccounts, sourceAccountNumber);
        BankAccount targetAccount = BankAccount.getBankAccountByNumber(bankAccounts, targetAccountNumber);

        if (sourceAccount != null && targetAccount != null) {
            System.out.print("Enter the amount to transfer from Account " + sourceAccount.getAccountNumber()
                    + " to Account " + targetAccount.getAccountNumber() + ": ");
            double amount = scanner.nextDouble();

            // Ensure that the transfer amount is positive and doesn't exceed the source account balance
            if (amount > 0 && sourceAccount.getBalance() >= amount) {
                sourceAccount.withdraw(amount);
                targetAccount.deposit(amount);
                System.out.println("Transfer completed.");
            } else {
                System.out.println("Invalid transfer amount or insufficient balance.");
            }
        } else {
            System.out.println("One or both accounts do not belong to the customer or do not exist.");
        }
    }

    public void applyForLoan(Loan loan) {
        loanApplications.add(loan);
        System.out.println("Loan application submitted. Loan ID: " + loan.getLoanID());
    }

    public void applyForLoan(Bank bank) {
        Scanner scanner = getScanner();
        try {
            System.out.print("Enter the loan amount: ");
            double loanAmount = scanner.nextDouble();

            System.out.print("Enter the loan term (in months): ");
            int loanTerm = scanner.nextInt();

            System.out.print("Enter the interest rate: ");
            double interestRate = scanner.nextDouble();

            // Create a new loan
            Loan loan = new Loan(loanAmount, loanTerm, interestRate, getId());

            // Add the loan to the bank
            bank.addLoan(loan);

            // Inform the customer that the loan application was successful
            System.out.println("Loan application submitted successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid loan details.");
            scanner.nextLine(); // Consume the invalid input
        }
    }


    public List<Loan> getLoanApplications() {
        return loanApplications;
    }

    public void viewLoanApplications() {
        System.out.println("Loan Applications:");
        for (Loan loan : loanApplications) {
            System.out.println("Loan ID: " + loan.getLoanID());
            System.out.println("Loan Amount: " + loan.getLoanAmount());
            System.out.println("Loan Term: " + loan.getLoanTerm() + " months");
            System.out.println("Interest Rate: " + loan.getInterestRate() + "%");
            System.out.println("Status: " + loan.getStatus());
            System.out.println();
        }
    }
}

