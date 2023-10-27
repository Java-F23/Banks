import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class addAccountTypeUI extends JFrame {
    private JTextField typeField;
    private JTextField nameField;
    private JTextField featuresField;
    private JButton addButton;

    private ArrayList<BankAccountType> accountTypes;

    public addAccountTypeUI(ArrayList<BankAccountType> existingAccountTypes) {
        setTitle("Add Account Type");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        this.accountTypes = existingAccountTypes;

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel typeLabel = new JLabel("Account Type Number:");
        typeField = new JTextField();

        JLabel nameLabel = new JLabel("Account Name:");
        nameField = new JTextField();

        JLabel featuresLabel = new JLabel("Account Features:");
        featuresField = new JTextField();

        addButton = new JButton("Add Account Type");

        panel.add(typeLabel);
        panel.add(typeField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(featuresLabel);
        panel.add(featuresField);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAccountType();
            }
        });

        add(panel);
    }

    private void addAccountType() {
        try {
            int type = Integer.parseInt(typeField.getText());

            // Check if the provided account type number already exists
            boolean accountTypeExists = false;
            for (BankAccountType currType : accountTypes) {
                if (type == currType.getType()) {
                    accountTypeExists = true;
                    break;
                }
            }

            if (accountTypeExists) {
                JOptionPane.showMessageDialog(this, "Account type number already exists. Please choose a different number.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String name = nameField.getText();
                String features = featuresField.getText();

                BankAccountType accountType = new BankAccountType(type, name, features);
                accountTypes.add(accountType);
                JOptionPane.showMessageDialog(this, "Account type added successfully!");
                dispose();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
