import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class withdrawUI extends JFrame {
    private Customer customer;
    private JComboBox<String> accountComboBox; // Combo box for selecting an account
    private JTextField amountField;

    public withdrawUI(Customer customer) {
        super("Withdraw from Account");
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

        JLabel instructionLabel = new JLabel("Enter the amount to withdraw:");
        instructionLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        amountField = new JTextField(10);
        amountField.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setFont(new Font("Arial", Font.BOLD, 16));
        withdrawButton.setBackground(new Color(66, 134, 244));
        withdrawButton.setForeground(Color.WHITE);
        withdrawButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.add(selectAccountLabel);
        this.add(accountComboBox);
        this.add(instructionLabel);
        this.add(amountField);
        this.add(withdrawButton);

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdrawFromAccount();
            }
        });
    }

    private void withdrawFromAccount() {
        try {
            int selectedAccountIndex = accountComboBox.getSelectedIndex();
            if (selectedAccountIndex >= 0) {
                double amount = Double.parseDouble(amountField.getText());
                List<BankAccount> accounts = customer.getAvailableBankAccounts();
                BankAccount selectedAccount = accounts.get(selectedAccountIndex);
                if (selectedAccount.withdraw(amount) == 1)
                {
                    JOptionPane.showMessageDialog(this, "Withdrawal successful.");
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Withdrawal Failed!\nInvalid amount or insufficient balance.");
                }
                this.dispose(); // Close the frame after withdrawing
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
