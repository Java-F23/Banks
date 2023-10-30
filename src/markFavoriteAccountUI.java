import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class markFavoriteAccountUI extends JFrame {
    private final Customer customer;
    private final JComboBox<String> accountComboBox;

    public markFavoriteAccountUI(Customer customer) {
        super("Mark Account as Favorite");
        this.customer = customer;
        this.setSize(400, 150);
        this.setLayout(new GridLayout(3, 1));
        this.setLocationRelativeTo(null);

        JLabel instructionLabel = new JLabel("Select an account to mark as favorite:");
        instructionLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        // Get the list of customer's accounts
        List<BankAccount> customerAccounts = customer.getAvailableBankAccounts();

        // Create an array of account descriptions for the combo box
        String[] accountDescriptions = new String[customerAccounts.size()];
        for (int i = 0; i < customerAccounts.size(); i++) {
            BankAccount account = customerAccounts.get(i);
            accountDescriptions[i] = "Account ID: " + account.getAccountNumber() + ", Balance: $" + account.getBalance();
        }

        accountComboBox = new JComboBox<>(accountDescriptions);
        accountComboBox.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton markButton = new JButton("Mark as Favorite");
        markButton.setFont(new Font("Arial", Font.BOLD, 16));
        markButton.setBackground(new Color(66, 134, 244));
        markButton.setForeground(Color.WHITE);
        markButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.add(instructionLabel);
        this.add(accountComboBox);
        this.add(markButton);

        markButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markAccountAsFavorite();
            }
        });
    }

    private void markAccountAsFavorite() {
        int selectedAccountIndex = accountComboBox.getSelectedIndex();
        if (selectedAccountIndex >= 0) {
            BankAccount selectedAccount = customer.getAvailableBankAccounts().get(selectedAccountIndex);
            customer.markAccountAsFavorite(selectedAccount);
            // Display a message indicating that the account is marked as a favorite
            JOptionPane.showMessageDialog(this, "Account marked as favorite.");
        } else {
            // Display a message indicating that no account is selected
            JOptionPane.showMessageDialog(this, "Please select an account to mark as a favorite.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
