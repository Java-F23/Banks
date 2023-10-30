import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class getAccountsByCategoryUI extends JFrame {
    private final JComboBox<Integer> categoryComboBox;
    private final JTextArea resultTextArea;
    private final JButton getAccountsButton;

    public getAccountsByCategoryUI(ArrayList<Customer> customers) {
        setTitle("Get Accounts by Category");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Use integers as values for the categoryComboBox
        categoryComboBox = new JComboBox<>(new Integer[]{1, 2, 3});
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
        int selectedCategory = (Integer) categoryComboBox.getSelectedItem();
        List<BankAccount> categoryAccounts = getAccountsByCategory(selectedCategory, customers);

        // Display the results in the text area
        displayCategoryAccounts(categoryAccounts);
    }

    public static List<BankAccount> getAccountsByCategory(int category, List<Customer> customers) {
        List<BankAccount> categoryAccounts = new ArrayList<>();
        for (Customer customer : customers) {
            for (BankAccount account : customer.getAvailableBankAccounts()) {
                if (account.getAccountType() == category) {
                    categoryAccounts.add(account);
                }
            }
        }
        return categoryAccounts;
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
