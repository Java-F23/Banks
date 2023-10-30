import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class searchAccountsUI extends JFrame {
    private final Customer customer;

    private final JTextField accountTypeField;
    private final JTextField minBalanceField;
    private final JTextField maxBalanceField;
    private final JButton searchButton;
    private final JTable table;

    public searchAccountsUI(Customer customer) {
        super("Search Accounts");
        this.customer = customer;
        this.setSize(600, 400);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        // Create input panel with GridLayout
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5)); // Adjusted the rows and added spacing

        inputPanel.add(new JLabel("Account Type (-1 for any):"));
        accountTypeField = new JTextField(10);
        inputPanel.add(accountTypeField);
        inputPanel.add(new JLabel("Minimum Balance:"));
        minBalanceField = new JTextField(10);
        inputPanel.add(minBalanceField);
        inputPanel.add(new JLabel("Maximum Balance:"));
        maxBalanceField = new JTextField(10);
        inputPanel.add(maxBalanceField);

        // Create the search button
        searchButton = new JButton("Search");

        // Add an empty label for spacing
        inputPanel.add(new JLabel());
        inputPanel.add(searchButton); // Place the search button at the end

        // Create the table to display search results
        table = new JTable(new DefaultTableModel(new Object[]{"Account ID", "Balance"}, 0));
        JScrollPane tableScrollPane = new JScrollPane(table);

        this.add(inputPanel, BorderLayout.NORTH);
        this.add(tableScrollPane, BorderLayout.CENTER);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBankAccountsByFilter();
            }
        });
    }

    private void searchBankAccountsByFilter() {
        int accountType = Integer.parseInt(accountTypeField.getText());
        double minBalance = Double.parseDouble(minBalanceField.getText());
        double maxBalance = Double.parseDouble(maxBalanceField.getText());

        List<BankAccount> matchingAccounts = customer.searchBankAccountsByFilter(accountType, minBalance, maxBalance);

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (BankAccount account : matchingAccounts) {
            model.addRow(new Object[]{account.getAccountNumber(), account.getBalance()});
        }
    }
}