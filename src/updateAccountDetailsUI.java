import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class updateAccountDetailsUI extends JFrame {
    private final JComboBox<String> accountTypeComboBox;
    private final JTextField accountNumberField;
    private final JTextField balanceField;
    private final JButton updateButton;

    public updateAccountDetailsUI(List<BankAccount> accounts, List<BankAccountType> accountTypes) {
        setTitle("Update Account Details");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel accountNumberLabel = new JLabel("Account Number:");
        accountNumberField = new JTextField();

        JLabel accountTypeLabel = new JLabel("New Account Type:");
        String[] accountTypeNames = new String[accountTypes.size()];
        for (int i = 0; i < accountTypes.size(); i++) {
            accountTypeNames[i] = accountTypes.get(i).getName();
        }
        accountTypeComboBox = new JComboBox<>(accountTypeNames);

        JLabel balanceLabel = new JLabel("New Balance:");
        balanceField = new JTextField();

        updateButton = new JButton("Update Account");

        panel.add(accountNumberLabel);
        panel.add(accountNumberField);
        panel.add(accountTypeLabel);
        panel.add(accountTypeComboBox);
        panel.add(balanceLabel);
        panel.add(balanceField);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(updateButton);
        add(panel);
    }

    public JComboBox<String> getAccountTypeComboBox() {
        return accountTypeComboBox;
    }

    public JTextField getAccountNumberField() {
        return accountNumberField;
    }

    public JTextField getBalanceField() {
        return balanceField;
    }

    public JButton getUpdateButton() {
        return updateButton;
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
}
