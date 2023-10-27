import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class getAccountsByCategoryUI extends JFrame {
    private JComboBox<String> categoryComboBox;
    private JTextArea resultTextArea;
    private JButton getAccountsButton;

    public getAccountsByCategoryUI(ArrayList<Customer> customers) {
        setTitle("Get Accounts by Category");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        categoryComboBox = new JComboBox<>(new String[]{"Category 1", "Category 2", "Category 3"});
        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);

        getAccountsButton = new JButton("Get Accounts");

        panel.add(categoryComboBox, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(getAccountsButton, BorderLayout.SOUTH);

        getAccountsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getAccountsByCategory(customers);
            }
        });

        add(panel);
    }

    private void getAccountsByCategory(ArrayList<Customer> customers) {
        String selectedCategory = (String) categoryComboBox.getSelectedItem();
        int category = getCategoryNumber(selectedCategory);

        if (category == -1) {
            JOptionPane.showMessageDialog(this, "Invalid category selected.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ArrayList<BankAccount> categoryAccounts = new ArrayList<BankAccount>();
        for (Customer customer : customers) {
            for (BankAccount account : customer.getAvailableBankAccounts()) {
                if (account.getAccountType() == category) {
                    categoryAccounts.add(account);
                }
            }
        }

        // Display the results in the text area
        displayCategoryAccounts(categoryAccounts);
    }

    private int getCategoryNumber(String category) {
        // Map category name to category number
        if (category.equals("Category 1")) {
            return 1;
        } else if (category.equals("Category 2")) {
            return 2;
        } else if (category.equals("Category 3")) {
            return 3;
        } else {
            return -1; // Invalid category
        }
    }

    private void displayCategoryAccounts(List<BankAccount> categoryAccounts) {
        StringBuilder result = new StringBuilder("Accounts in Selected Category:\n");
        if (categoryAccounts.isEmpty()) {
            result.append("No accounts found in this category.");
        } else {
            for (BankAccount account : categoryAccounts) {
                result.append("Account Number: ").append(account.getAccountNumber()).append("\n");
            }
        }

        resultTextArea.setText(result.toString());
    }
}
