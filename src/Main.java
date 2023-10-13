import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        List<Customer> customers = new ArrayList<>();

        // Create and add some example customers
        customers.add(new Customer(1, "John Doe"));
        customers.add(new Customer(2, "Jane Smith"));

        admin.addAccountType(1, "Savings Account", "Interest-bearing account");
        admin.addAccountType(2, "Checking Account", "No interest");
        admin.addAccountType(3, "Business Account", "For business use");

        while (true) {
            System.out.println("Bank Management System Menu:");
            System.out.println("1. Add New Customer");
            System.out.println("2. Admin Menu");
            System.out.println("3. Customer Menu");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    boolean isTaken;
                    String custName;
                    int custID;
                    System.out.print("Enter Customer Name:");
                    custName = scanner.next();
                    do {
                        isTaken = false; // Set isTaken to false at the beginning of each iteration
                        System.out.print("Enter Custom ID:");
                        custID = scanner.nextInt();
                        for (Customer currCust : customers) {
                            if (currCust.getId() == custID) {
                                isTaken = true; // Set isTaken to true if the ID is already taken
                                break;
                            }
                        }
                        if (isTaken) {
                            System.out.println("Customer ID is already taken. Please choose a different one.");
                        }
                    } while (isTaken);

                    customers.add(new Customer(custID, custName));
                    System.out.print("Customer Created Successfully!\n");
                    break;

                case 2:
                    adminMenu(admin, customers);
                    break;

                case 3:
                    // Switch to the customer menu based on the customer's ID
                    System.out.print("Enter customer ID: ");
                    int customerID = scanner.nextInt();
                    Customer customer = findCustomerByID(customers, customerID);
                    if (customer != null) {
                        customerMenu(customer);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the Bank Management System.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    public static Customer findCustomerByID(List<Customer> customers, int customerID) {
        for (Customer customer : customers) {
            if (customer.getId() == customerID) {
                return customer;
            }
        }
        return null; // Customer not found
    }

    public static void adminMenu(Admin admin, List<Customer> customers) {
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Create New Account");
            System.out.println("2. Update Account Details");
            System.out.println("3. Generate Reports");
            System.out.println("4. Add Account Type");
            System.out.println("5. Remove Account Type");
            System.out.println("6. Browse Accounts by Category");
            System.out.println("7. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = admin.getScanner().nextInt();

            switch (choice) {
                case 1:
                    // Prompt for customer ID
                    System.out.print("Enter Customer ID: ");
                    int customerID = admin.getScanner().nextInt();

                    // Find the customer
                    Customer customer = findCustomerByID(customers, customerID);
                    if (customer != null) {
                        BankAccount newAcc = admin.createNewAccount(customerID);
                        customer.addBankAccount(newAcc);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 2:
                    admin.updateAccountDetails();
                    break;

                case 3:
                    admin.generateReports();
                    break;

                case 4:
                    admin.addAccountTypeManual();
                    break;

                case 5:
                    admin.removeAccountType();
                    break;

                case 6:
                    System.out.print("Enter category to browse: ");
                    int category = admin.getScanner().nextInt();
                    List<BankAccount> categoryAccounts = admin.getAccountsByCategory(category, customers);
                    System.out.print("Accounts that belong to category: "+category+"\n");
                    for (BankAccount account : categoryAccounts)
                    {
                        System.out.print("Account number: "+account.getAccountNumber()+"\n");
                        System.out.print("\n");
                    }
                    break;

                case 7:
                    return; // Return to the main menu

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    public static void customerMenu(Customer customer) {
        while (true) { //add view records, applying for a loan, view detailed activity of EACH ACCOUNT
            System.out.println("Customer Menu:");
            System.out.println("1. View Available Accounts");
            System.out.println("2. Search Accounts");
            System.out.println("3. View Account Details");
            System.out.println("4. Mark Account as Favorite");
            System.out.println("5. Deposit Money");
            System.out.println("6. Withdraw Money");
            System.out.println("7. View Favorite Accounts");
            System.out.println("8. Transfer Between Accounts");
            System.out.println("9. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = customer.getScanner().nextInt(); // Use customer's scanner

            switch (choice) {
                case 1:
                    List<BankAccount> availableAccounts = customer.getAvailableBankAccounts();
                    customer.displayAccounts(availableAccounts);
                    break;

                case 2:
                    List<BankAccount> matchingAccounts = customer.searchBankAccountsByFilter();
                    customer.displayAccounts(matchingAccounts);
                    break;

                case 3:
                    BankAccount account = customer.getBankAccountByNumber();
                    customer.viewAccountDetails(account);
                    break;

                case 4:
                    BankAccount favoriteAccount = customer.getBankAccountByNumber();
                    customer.markAccountAsFavorite(favoriteAccount);
                    break;

                case 5:
                    BankAccount depositAccount = customer.getBankAccountByNumber();
                    customer.depositToAccount(depositAccount);
                    break;

                case 6:
                    BankAccount withdrawAccount = customer.getBankAccountByNumber();
                    customer.withdrawFromAccount(withdrawAccount);
                    break;

                case 7:
                    List<BankAccount> favoriteAccounts = customer.getFavoriteAccounts();
                    customer.displayAccounts(favoriteAccounts);
                    break;

                case 8:
                    customer.transferBetweenAccounts();
                    break;

                case 9:
                    return; // Return to the main menu

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
