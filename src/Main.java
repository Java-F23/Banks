import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        admin admin = new admin("Mohamed Hashish");
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
}