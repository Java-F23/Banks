import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

class admin {
    private final String name;
    private ArrayList<BankAccount> accounts;
    private final ArrayList<BankAccountType> accountTypes;
    private final Scanner scanner;

    public admin(String name) {
        this.name = name;
        accounts = new ArrayList<>();
        accountTypes = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public String getName() {
        return name;
    }

    public ArrayList<BankAccount> getBankAccounts() {
        return accounts;
    }

    public ArrayList<BankAccountType> getBankAccountTypes() {
        return accountTypes;
    }

    public BankAccount createNewAccount(int accountType, int balance, int customerID) {

        // Create a new account with the specified account type
        BankAccount newAccount = new BankAccount(accountType, balance, customerID);
        accounts.add(newAccount);
        System.out.println("Account created with account number: " + newAccount.getAccountNumber());
        return newAccount;
    }

    public void addAccountType(int type, String name) {
        try {
            BankAccountType accountType = new BankAccountType(type, name);
            accountTypes.add(accountType);
//            System.out.println("Account type added.");
        } catch (InputMismatchException e) {
//            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine(); // Consume the invalid input
        }
    }

    public void setAccounts(ArrayList<BankAccount> acc)
    {
        this.accounts = acc;
    }

}

