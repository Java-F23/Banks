import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class transferBetweenAccsUI extends JFrame {
    private final customer customer;
    private final JComboBox<String> sourceAccountComboBox;
    private final JComboBox<String> targetAccountComboBox;
    private final JTextField amountField;

    public transferBetweenAccsUI(customer customer) {
        super("Transfer Between Accounts");
        this.customer = customer;
        this.setSize(600, 200);
        this.setLayout(new GridLayout(5, 1));
        this.setLocationRelativeTo(null);

        // Get a list of the customer's available bank accounts
        List<BankAccount> bankAccounts = customer.getAvailableBankAccounts();
        String[] accountDescriptions = new String[bankAccounts.size()];

        // Create account descriptions for the combo boxes
        for (int i = 0; i < bankAccounts.size(); i++) {
            accountDescriptions[i] = "Account ID: " + bankAccounts.get(i).getAccountNumber() + ", Balance: $" + bankAccounts.get(i).getBalance();
        }

        sourceAccountComboBox = new JComboBox<>(accountDescriptions);
        sourceAccountComboBox.setFont(new Font("Arial", Font.PLAIN, 16));

        targetAccountComboBox = new JComboBox<>(accountDescriptions);
        targetAccountComboBox.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel sourceAccountLabel = new JLabel("Select Source Account:");
        sourceAccountLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel targetAccountLabel = new JLabel("Select Target Account:");
        targetAccountLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel instructionLabel = new JLabel("Enter the amount to transfer:");
        instructionLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        amountField = new JTextField(10);
        amountField.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton transferButton = new JButton("Transfer");
        transferButton.setFont(new Font("Arial", Font.BOLD, 16));
        transferButton.setBackground(new Color(66, 134, 244));
        transferButton.setForeground(Color.WHITE);
        transferButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.add(sourceAccountLabel);
        this.add(sourceAccountComboBox);
        this.add(targetAccountLabel);
        this.add(targetAccountComboBox);
        this.add(instructionLabel);
        this.add(amountField);
        this.add(transferButton);

        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transferBetweenAccounts();
            }
        });
    }

    private void transferBetweenAccounts() {
        try {
            int sourceAccountIndex = sourceAccountComboBox.getSelectedIndex();
            int targetAccountIndex = targetAccountComboBox.getSelectedIndex();

            if (sourceAccountIndex >= 0 && targetAccountIndex >= 0) {
                double amount = Double.parseDouble(amountField.getText());
                List<BankAccount> accounts = customer.getAvailableBankAccounts();
                BankAccount sourceAccount = accounts.get(sourceAccountIndex);
                BankAccount targetAccount = accounts.get(targetAccountIndex);

                // Ensure that the transfer amount is positive and doesn't exceed the source account balance
                if (amount > 0 && sourceAccount.getBalance() >= amount) {
                    sourceAccount.withdraw(amount);
                    targetAccount.deposit(amount);
                    // Display a message indicating that the transfer was successful
                    JOptionPane.showMessageDialog(this, "Transfer completed.");
                    this.dispose(); // Close the frame after the transfer
                } else {
                    // Display an error message for an invalid transfer amount or insufficient balance
                    JOptionPane.showMessageDialog(this, "Invalid transfer amount or insufficient balance.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Display an error message for one or both accounts not selected
                JOptionPane.showMessageDialog(this, "Please select source and target accounts.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            // Display an error message for invalid input
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
