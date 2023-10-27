import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class updateAccountDetailsUI extends JFrame {
    private JComboBox<String> accountTypeComboBox;
    private JTextField accountNumberField;
    private JTextField balanceField;
    private JButton updateButton;

    private List<BankAccountType> accountTypes;

    public updateAccountDetailsUI(List<BankAccount> accounts, List<BankAccountType> accountTypes) {
        this.accountTypes = accountTypes;
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

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int accountNumber = Integer.parseInt(accountNumberField.getText());
                    int selectedAccountTypeIndex = accountTypeComboBox.getSelectedIndex();
                    int newAccountType = accountTypes.get(selectedAccountTypeIndex).getType();
                    double newBalance = Double.parseDouble(balanceField.getText());

                    BankAccount accountToUpdate = null;
                    for (BankAccount account : accounts) {
                        if (account.getAccountNumber() == accountNumber) {
                            accountToUpdate = account;
                            break;
                        }
                    }

                    if (accountToUpdate == null) {
                        JOptionPane.showMessageDialog(updateAccountDetailsUI.this, "Account not found.");
                        return;
                    }

                    // Now update the account details.
                    accountToUpdate.updateAccount(newAccountType, newBalance);
                    JOptionPane.showMessageDialog(updateAccountDetailsUI.this, "Account details updated.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(updateAccountDetailsUI.this, "Invalid input. Please check the data entered.");
                }
            }
        });

        add(panel);
    }
}
