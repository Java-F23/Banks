import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Admin admin = new Admin("Mohamed Hashish");
        bank.addAdmin(admin);
        customer customer1 = new customer(1, "John Doe");
        customer customer2 = new customer(2, "Jane Smith");
        ArrayList<customer> customers = new ArrayList<>();
        bank.addCustomer(customer1);
        bank.addCustomer(customer2);
        customers.add(customer1);
        customers.add(customer2);
        admin.addAccountType(1, "Savings Account");
        admin.addAccountType(2, "Checking Account");
        admin.addAccountType(3, "Business Account");
        mainUI mainWindow = new mainUI("Main Window", 150, 600, admin, customers, bank);
//        adminUI adminWindow = new adminUI("Admin Section", 400, 400, admin);
//        customerUI custWindow = new customerUI("Customer Section", 400, 400, customer1); //change it later so that each cutomer is sent after logging in
//        SwingUtilities.invokeLater(()-> {
        mainWindow.setVisible(true);
        mainWindow.setResizable(false);
        JPanel welcomePanel = new JPanel();
        JLabel welcomeMessage = new JLabel("Welcome to the Banking Java App!");
        welcomeMessage.setHorizontalAlignment(JLabel.CENTER);
        welcomePanel.add(welcomeMessage);
// Use a JOptionPane to create a dialog
        JOptionPane.showMessageDialog(null, welcomePanel, "Welcome!", JOptionPane.PLAIN_MESSAGE);
//        });

//        while (true) {
//            try {
//                System.out.println("Bank Management System Menu:");
//                System.out.println("1. Add New Customer");
//                System.out.println("2. Admin Menu");
//                System.out.println("3. Customer Menu");
//                System.out.println("4. Exit");
//
//                System.out.print("Enter your choice: ");
//                Scanner scanner = new Scanner(System.in);
//                int choice = scanner.nextInt();
//
//                switch (choice) {
//                    case 1:
//                        boolean isTaken;
//                        String custName;
//                        int custID = 0;
//                        System.out.print("Enter Customer Name:");
//                        custName = scanner.next();
//                        do {
//                            isTaken = false;
//                            System.out.print("Enter Custom ID:");
//                            try {
//                                custID = scanner.nextInt();
//                                for (Customer currCust : customers) {
//                                    if (currCust.getId() == custID) {
//                                        isTaken = true;
//                                        break;
//                                    }
//                                }
//                                if (isTaken) {
//                                    System.out.println("Customer ID is already taken. Please choose a different one.");
//                                }
//                            } catch (InputMismatchException e) {
//                                System.out.println("Invalid input. Please enter a valid ID.");
//                                scanner.nextLine(); // Consume the invalid input
//                                isTaken = true; // Mark as taken to re-enter the ID
//                            }
//                        } while (isTaken);
//
//                        customers.add(new Customer(custID, custName));
//                        bank.addCustomer(new Customer(custID, custName));
//                        System.out.print("Customer Created Successfully!\n");
//                        break;
//
//                    case 2:
//                        adminMenu(admin, customers, bank);
//                        break;
//
//                    case 3:
//                        System.out.print("Enter customer ID: ");
//                        int customerID = scanner.nextInt();
//                        Customer customer = findCustomerByID(customers, customerID);
//                        if (customer != null) {
//                            customerMenu(customer, bank);
//                        } else {
//                            System.out.println("Customer not found.");
//                        }
//                        break;
//
//                    case 4:
//                        System.out.println("Exiting the Bank Management System.");
//                        System.exit(0);
//                        break;
//
//                    default:
//                        System.out.println("Invalid choice. Please enter a valid option.");
//                }
//            } catch (InputMismatchException e) {
//                System.out.println("Invalid input. Please enter a valid option.");
//            }
//        }
    }

    public static customer findCustomerByID(List<customer> customers, int customerID) {
        for (customer customer : customers) {
            if (customer.getId() == customerID) {
                return customer;
            }
        }
        return null;
    }
}

//    public static void adminMenu(Admin admin, List<Customer> customers, Bank bank) {
//        while (true) {
//            try {
//                System.out.println("Admin Menu:");
//                System.out.println("1. Create New Account");
//                System.out.println("2. Update Account Details");
//                System.out.println("3. Generate Reports");
//                System.out.println("4. Add Account Type");
//                System.out.println("5. Remove Account Type");
//                System.out.println("6. Browse Accounts by Category");
//                System.out.println("7. Back to Main Menu");
//
//                System.out.print("Enter your choice: ");
//                int choice = admin.getScanner().nextInt();
//
//                switch (choice) {
//                    case 1:
//                        System.out.print("Enter Customer ID: ");
//                        int customerID = admin.getScanner().nextInt();
//                        Customer customer = findCustomerByID(customers, customerID);
//                        if (customer != null) {
//                            BankAccount newAcc = admin.createNewAccount(customerID);
//                            customer.addBankAccount(newAcc);
//                            bank.addAccount(newAcc);
//                        } else {
//                            System.out.println("Customer not found.");
//                        }
//                        break;
//
//                    case 2:
//                        admin.updateAccountDetails();
//                        break;
//
//                    case 3:
//                        admin.generateReports();
//                        break;
//
//                    case 4:
//                        admin.addAccountTypeManual();
//                        break;
//
//                    case 5:
//                        admin.removeAccountType();
//                        break;
//
//                    case 6:
//                        System.out.print("Enter category to browse: ");
//                        int category = admin.getScanner().nextInt();
//                        List<BankAccount> categoryAccounts = admin.getAccountsByCategory(category, customers);
//                        System.out.print("Accounts that belong to category: "+category+"\n");
//                        for (BankAccount account : categoryAccounts)
//                        {
//                            System.out.print("Account number: "+account.getAccountNumber()+"\n");
//                            System.out.print("\n");
//                        }
//                        break;
//
//                    case 7:
//                        return; // Return to the main menu
//
//                    default:
//                        System.out.println("Invalid choice. Please enter a valid option.");
//                }
//            } catch (InputMismatchException e) {
//                System.out.println("Invalid input. Please enter a valid option.");
//            }
//        }
//    }

//    public static void customerMenu(Customer customer, Bank bank) {
//        while (true) {
//            try {
//                System.out.println("Customer Menu:");
//                System.out.println("1. View Available Accounts");
//                System.out.println("2. Search Accounts");
//                System.out.println("3. View Account Details");
//                System.out.println("4. Mark Account as Favorite");
//                System.out.println("5. Deposit Money");
//                System.out.println("6. Withdraw Money");
//                System.out.println("7. View Favorite Accounts");
//                System.out.println("8. Transfer Between Accounts");
//                System.out.println("9. View All Activities");
//                System.out.println("10. View Activity of An Account");
//                System.out.println("11. Apply For A Loan");
//                System.out.println("12. Back to Main Menu");
//
//                System.out.print("Enter your choice: ");
//                int choice = customer.getScanner().nextInt();
//
//                switch (choice) {
//                    case 1:
//                        List<BankAccount> availableAccounts = customer.getAvailableBankAccounts();
//                        customer.displayAccounts(availableAccounts);
//                        break;
//
//                    case 2:
//                        List<BankAccount> matchingAccounts = customer.searchBankAccountsByFilter();
//                        customer.displayAccounts(matchingAccounts);
//                        break;
//
//                    case 3:
//                        BankAccount account = customer.getBankAccountByNumber();
//                        customer.viewAccountDetails(account);
//                        break;
//
//                    case 4:
//                        BankAccount favoriteAccount = customer.getBankAccountByNumber();
//                        customer.markAccountAsFavorite(favoriteAccount);
//                        break;
//
//                    case 5:
//                        BankAccount depositAccount = customer.getBankAccountByNumber();
//                        customer.depositToAccount(depositAccount);
//                        break;
//
//                    case 6:
//                        BankAccount withdrawAccount = customer.getBankAccountByNumber();
//                        customer.withdrawFromAccount(withdrawAccount);
//                        break;
//
//                    case 7:
//                        List<BankAccount> favoriteAccounts = customer.getFavoriteAccounts();
//                        customer.displayAccounts(favoriteAccounts);
//                        break;
//
//                    case 8:
//                        customer.transferBetweenAccounts();
//                        break;
//
//                    case 9:
//                        customer.viewAllRecords();
//                        break;
//
//                    case 10:
//                        BankAccount acc = customer.getBankAccountByNumber();
//                        customer.viewAccountRecords(acc);
//                        break;
//
//                    case 11:
//                        customer.applyForLoan(bank);
//                        break;
//
//                    case 12:
//                        return;
//
//                    default:
//                        System.out.println("Invalid choice. Please enter a valid option.");
//                }
//            } catch (InputMismatchException e) {
//                System.out.println("Invalid input. Please enter a valid option.");
//            }
//        }
//    }

