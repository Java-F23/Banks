import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

class Admin {
    private final String name;
    private final ArrayList<BankAccount> accounts;
    private final ArrayList<BankAccountType> accountTypes;
    private final Scanner scanner;

    public Admin(String name) {
        this.name = name;
        accounts = new ArrayList<>();
        accountTypes = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<BankAccount> getBankAccounts()
    {
        return accounts;
    }

    public ArrayList<BankAccountType> getBankAccountTypes()
    {
        return accountTypes;
    }

    public BankAccount createNewAccount(int accountType, int balance, int customerID) {
//        System.out.println("Available Account Types:");
//        for (BankAccountType type : accountTypes) {
//            System.out.println(type.getType() + ": " + type.getName());
//        }
//
//        try {
//            System.out.print("Enter account type: ");
//            int accountType = scanner.nextInt();
//
//            // Check if the entered account type is valid
//            boolean validAccountType = false;
//            for (BankAccountType type : accountTypes) {
//                if (type.getType() == accountType) {
//                    validAccountType = true;
//                    break;
//                }
//            }
//
//            if (!validAccountType) {
//                System.out.println("Invalid account type. Account creation failed.");
//                return null;
//            }
//
//            System.out.print("Enter initial balance: ");
//            double initialBalance = scanner.nextDouble();

            // Create a new account with the specified account type
            BankAccount newAccount = new BankAccount(accountType, balance, customerID);
            accounts.add(newAccount);
            System.out.println("Account created with account number: " + newAccount.getAccountNumber());
            return newAccount;
//        } catch (InputMismatchException e) {
//            System.out.println("Invalid input. Please enter a valid number.");
//            scanner.nextLine(); // Consume the invalid input
//            return null;
//        }
    }

    public void addAccountType(int type, String name) {
        try {
            BankAccountType accountType = new BankAccountType(type, name);
            accountTypes.add(accountType);
            System.out.println("Account type added.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine(); // Consume the invalid input
        }
    }

}

