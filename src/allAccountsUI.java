import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class allAccountsUI extends JFrame {
    private final customer customer;

    public allAccountsUI(customer customer) {
        super("All Accounts");
        this.customer = customer;
        this.setSize(800, 400);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        // Get the available bank accounts for the customer
        ArrayList<BankAccount> bankAccounts = this.customer.getAvailableBankAccounts();

        String[] columnNames = {"Account ID", "Account Type", "Balance"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Populate the table model with data
        for (BankAccount account : bankAccounts) {
            Object[] rowData = {account.getAccountNumber(), getAccountTypeName(account.getAccountType()), "$" + account.getBalance()};
            model.addRow(rowData);
        }

        // Create the JTable
        JTable table = new JTable(model);
        table.setFont(new Font("Arial", Font.PLAIN, 16));

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    // Helper method to get account type name based on account type ID
    private String getAccountTypeName(int accountType) {
        // Replace this with logic to get the account type name based on the account type ID
        switch (accountType) {
            case 1:
                return "Savings Account";
            case 2:
                return "Checking Account";
            case 3:
                return "Business Account";
            default:
                return "Unknown Type";
        }
    }
}
