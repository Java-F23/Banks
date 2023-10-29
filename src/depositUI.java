import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class depositUI extends JFrame {
    private Customer customer;
    private JComboBox<String> accountComboBox; // Combo box for selecting an account
    private JTextField amountField;

    public depositUI(Customer customer) {
        super("Deposit to Account");
        this.customer = customer;
        this.setSize(600, 150);
        this.setLayout(new GridLayout(4, 1));
        this.setLocationRelativeTo(null);

        JLabel selectAccountLabel = new JLabel("Select an Account:");
        selectAccountLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        // Create a list of account descriptions for the combo box
        List<BankAccount> accounts = customer.getAvailableBankAccounts();
        String[] accountDescriptions = new String[accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {
            accountDescriptions[i] = "Account ID: " + accounts.get(i).getAccountNumber() + ", Balance: $" + accounts.get(i).getBalance();
        }

        accountComboBox = new JComboBox<>(accountDescriptions);
        accountComboBox.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel instructionLabel = new JLabel("Enter the amount to deposit:");
        instructionLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        amountField = new JTextField(10);
        amountField.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton depositButton = new JButton("Deposit");
        depositButton.setFont(new Font("Arial", Font.BOLD, 16));
        depositButton.setBackground(new Color(66, 134, 244));
        depositButton.setForeground(Color.WHITE);
        depositButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.add(selectAccountLabel);
        this.add(accountComboBox);
        this.add(instructionLabel);
        this.add(amountField);
        this.add(depositButton);

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depositToAccount();
            }
        });
    }

    private void depositToAccount() {
        try {
            int selectedAccountIndex = accountComboBox.getSelectedIndex();
            if (selectedAccountIndex >= 0) {
                double amount = Double.parseDouble(amountField.getText());
                List<BankAccount> accounts = customer.getAvailableBankAccounts();
                BankAccount selectedAccount = accounts.get(selectedAccountIndex);
                selectedAccount.deposit(amount);
                // Display a message indicating that the deposit was successful
                JOptionPane.showMessageDialog(this, "Deposit successful.");
                this.dispose(); // Close the frame after depositing
            } else {
                // Display an error message for no account selected
                JOptionPane.showMessageDialog(this, "Please select an account.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            // Display a message for invalid input
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
