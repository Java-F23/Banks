import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        admin admin = new admin("Mohamed Hashish");
        ArrayList<customer> customers = new ArrayList<>();
        bank.addAdmin(admin);

        customers = readCustomersFromCSV("customers.csv");
        for (customer cust : customers) {
            bank.addCustomer(cust);
        }

        List<BankAccountType> accountTypes = readAccountTypesFromCSV("accountTypes.csv");
        for (BankAccountType accType : accountTypes) {
            admin.addAccountType(accType.getType(), accType.getName());
        }

        ArrayList<BankAccount> accounts = readAccountsFromCSV("accounts.csv");

        assignBankAccountsToCustomers(customers, accounts);
        mainUI mainWindow = new mainUI("Main Window", 150, 600, admin, customers, bank, accounts);
        mainWindow.setVisible(true);
        mainWindow.setResizable(false);
        JPanel welcomePanel = new JPanel();
        JLabel welcomeMessage = new JLabel("Welcome to the Banking Java App!");
        welcomeMessage.setHorizontalAlignment(JLabel.CENTER);
        welcomePanel.add(welcomeMessage);
        JOptionPane.showMessageDialog(null, welcomePanel, "Welcome!", JOptionPane.PLAIN_MESSAGE);
    }

    public static customer findCustomerByID(List<customer> customers, int customerID) {
        for (customer customer : customers) {
            if (customer.getId() == customerID) {
                return customer;
            }
        }
        return null;
    }

    private static ArrayList<customer> readCustomersFromCSV(String fileName) {
        ArrayList<customer> customers = new ArrayList<>();
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    customers.add(new customer(id, name));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + fileName);
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error reading file - " + fileName);
            e.printStackTrace();
        }
        return customers;
    }


    private static ArrayList<BankAccountType> readAccountTypesFromCSV(String fileName) {
        ArrayList<BankAccountType> accountTypes = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    int type = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    accountTypes.add(new BankAccountType(type, name));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return accountTypes;
    }

    private static ArrayList<BankAccount> readAccountsFromCSV(String fileName) {
        ArrayList<BankAccount> accounts = new ArrayList<>();
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    int accountNumber = Integer.parseInt(parts[0]);
                    int accountType = Integer.parseInt(parts[1]);
                    double balance = Double.parseDouble(parts[2]);
                    int customerID = Integer.parseInt(parts[3]);

                    BankAccount account = new BankAccount(accountNumber, accountType, balance, customerID);
                    accounts.add(account);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + fileName);
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error reading file - " + fileName);
            e.printStackTrace();
        }

        System.out.println("Accounts read from file: " + accounts.size());
        return accounts;
    }

    private static void assignBankAccountsToCustomers(ArrayList<customer> customers, ArrayList<BankAccount> accounts) {
        // Assuming each customer has a unique ID
        for (customer customer : customers) {
            int customerID = customer.getId();
            // Find accounts associated with the current customer
            ArrayList<BankAccount> customerAccounts = new ArrayList<>();
            for (BankAccount account : accounts) {
                if (account.getCustomerID() == customerID) {
                    customerAccounts.add(account);
                }
            }
            // Assign the accounts to the customer
            customer.setBankAccounts(customerAccounts);
        }
    }
}