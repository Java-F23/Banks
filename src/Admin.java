import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Admin {
    private List<BankAccount> accounts;
    private List<BankAccountType> accountTypes;
    private Scanner scanner;

    public Admin() {
        accounts = new ArrayList<>();
        accountTypes = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public Scanner getScanner() {
        return scanner;
    }

    public BankAccount createNewAccount(int customerID) {
        System.out.println("Available Account Types:");
        for (BankAccountType type : accountTypes) {
            System.out.println(type.getType() + ": " + type.getName());
        }

        System.out.print("Enter account type: ");
        int accountType = scanner.nextInt();

        // Check if the entered account type is valid
        boolean validAccountType = false;
        for (BankAccountType type : accountTypes) {
            if (type.getType() == accountType) {
                validAccountType = true;
                break;
            }
        }

        if (!validAccountType) {
            System.out.println("Invalid account type. Account creation failed.");
            return null;
        }

        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        // Create a new account with the specified account type
        BankAccount newAccount = new BankAccount(accountType, initialBalance, customerID);
        accounts.add(newAccount);
        System.out.println("Account created with account number: " + newAccount.getAccountNumber());
        return newAccount;
    }

    public void updateAccountDetails() {
        System.out.print("Enter account number to update: ");
        int accountNumberToUpdate = scanner.nextInt();

        BankAccount accountToUpdate = null;
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumberToUpdate) {
                accountToUpdate = account;
                break;
            }
        }

        if (accountToUpdate == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter new account type: ");
        int newAccountType = scanner.nextInt();
        boolean validAccountType = false;
        for (BankAccountType type : accountTypes) {
            if (type.getType() == newAccountType) {
                validAccountType = true;
                break;
            }
        }

        if (!validAccountType) {
            System.out.println("Invalid account type.");
            return;
        }

        System.out.print("Enter new balance: ");
        double newBalance = scanner.nextDouble();

        // Now update the account details.
        accountToUpdate.updateAccount(newAccountType, newBalance);
        System.out.println("Account details updated.");
    }


    public void generateReports() {
        System.out.println("Account Number\tBalance");
        for (BankAccount account : accounts) {
            System.out.println(account.getAccountNumber() + "       \t" + account.getBalance());
        }

        int totalAccounts = accounts.size();
        System.out.println("Total number of accounts: " + totalAccounts);
    }

    public void addAccountType(int type, String name, String features) {
        BankAccountType accountType = new BankAccountType(type, name, features);
        accountTypes.add(accountType);
        System.out.println("Account type added.");
    }

    public void addAccountTypeManual() {
        System.out.print("Enter account type: ");
        int type = scanner.nextInt();

        // Check if the provided account type number already exists
        boolean accountTypeExists = false;
        for(BankAccountType currType: accountTypes)
        {
            if(type == currType.getType())
            {
                accountTypeExists = true;
                break;
            }
        }

        if (accountTypeExists) {
            System.out.println("Account type number already exists. Please choose a different number.");
            return;
        }

        System.out.print("Enter account name: ");
        String name = scanner.next();
        System.out.print("Enter account features: ");
        String features = scanner.next();

        BankAccountType accountType = new BankAccountType(type, name, features);
        accountTypes.add(accountType);
        System.out.println("Account type added.");
    }


    public void removeAccountType() {
        System.out.print("Enter account type to remove: ");
        int typeToRemove = scanner.nextInt();
        for (BankAccountType accountType : accountTypes) {
            if (accountType.getType() == typeToRemove) {
                accountTypes.remove(accountType);
                System.out.println("Account type removed.");
                return;
            }
        }
        System.out.println("Account type not found.");
    }

    public List<BankAccount> getAccountsByCategory(int category, List<Customer> customers) {
        List<BankAccount> categoryAccounts = new ArrayList<>();
        for(Customer customer:customers)
        {
            for (BankAccount account : customer.getAvailableBankAccounts()) {
                if (account.getAccountType() == category) {
                    categoryAccounts.add(account);
                }
            }
        }
        return categoryAccounts;
    }
}
