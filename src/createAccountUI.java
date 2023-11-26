import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class createAccountUI extends JFrame {
    private final JComboBox<String> accountTypeComboBox;
    private final JTextField initialBalanceField;
    private final JTextField customerIdField;
    private final JButton createAccountButton;

    private final ArrayList<customer> customers;

    public createAccountUI(admin admin, ArrayList<customer> custs) {
        customers = custs;
        setTitle("Create Bank Account");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel accountTypeLabel = new JLabel("Account Type:");
        String[] accountTypes = {"Savings Account", "Checking Account", "Business Account"};
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

        this.add(panel);
    }

    public JComboBox<String> getAccountTypeComboBox() {
        return accountTypeComboBox;
    }

    public JTextField getInitialBalanceField() {
        return initialBalanceField;
    }

    public JTextField getCustomerIdField() {
        return customerIdField;
    }

    public void displayErrorMessage(String errorMessage) {
        displayMessage(errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void displaySuccessMessage(String successMessage) {
        displayMessage(successMessage, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void displayMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }

    public JButton getButton()
    {
        return this.createAccountButton;
    }
}
