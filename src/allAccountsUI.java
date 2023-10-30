import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class allAccountsUI extends JFrame {
    private final Customer customer;

    public allAccountsUI(Customer customer) {
        super("All Accounts");
        this.customer = customer;
        this.setSize(600, 400);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        // Get the available bank accounts for the customer
        ArrayList<BankAccount> bankAccounts = this.customer.getAvailableBankAccounts();

        // Define the table model with appropriate column names
        String[] columnNames = {"Account ID", "Balance"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Populate the table model with data
        for (BankAccount account : bankAccounts) {
            Object[] rowData = {account.getAccountNumber(), "$" + account.getBalance()};
            model.addRow(rowData);
        }

        // Create the JTable
        JTable table = new JTable(model);
        table.setFont(new Font("Arial", Font.PLAIN, 16));

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);
    }
}
