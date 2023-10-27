import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class createAccountUI extends JFrame {
    private JComboBox<String> accountTypeComboBox;
    private JTextField initialBalanceField;
    private JTextField customerIdField;
    private JButton createAccountButton;

    private ArrayList<Customer> customers;

    public createAccountUI(Admin admin, ArrayList<Customer> custs) {
        customers =custs;
        setTitle("Create Bank Account");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel accountTypeLabel = new JLabel("Account Type:");
        String[] accountTypes = { "Savings Account", "Checking Account", "Business Account" };
        accountTypeComboBox = new JComboBox<>(accountTypes);

        JLabel initialBalanceLabel = new JLabel("Initial Balance:");
        initialBalanceField = new JTextField();

        JLabel customerIdLabel = new JLabel("Customer ID:");
        customerIdField = new JTextField();

        createAccountButton = new JButton("Create Account");

        panel.add(accountTypeLabel);
        panel.add(accountTypeComboBox);
        panel.add(initialBalanceLabel);
        panel.add(initialBalanceField);
        panel.add(customerIdLabel);
        panel.add(customerIdField);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(createAccountButton);

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected account type, initial balance, and customer ID
                int selectedAccountType = accountTypeComboBox.getSelectedIndex();
                int initialBalance = Integer.parseInt(initialBalanceField.getText());
                int customerId = Integer.parseInt(customerIdField.getText());

                Customer customer = Main.findCustomerByID(customers, customerId);
                if (customer == null) {
                    // Display an error message if the customer is not found
                    JOptionPane.showMessageDialog(createAccountUI.this, "Customer not found. Please enter a valid customer ID.");
                } else {
                    // Create the bank account using admin and the provided data
                    BankAccount newAcc = admin.createNewAccount(selectedAccountType + 1, initialBalance, customerId);

                    // Display a success message using JOptionPane
                    JOptionPane.showMessageDialog(createAccountUI.this, "Account created successfully!\nAccount Number: "+newAcc.getAccountNumber());

                    // Close the create account window
                    dispose();
                }
            }
        });

        add(panel);
    }
}
