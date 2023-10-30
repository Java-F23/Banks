import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class allRecordsUI extends JFrame {
    private final Customer customer;

    public allRecordsUI(Customer customer) {
        super("All Records");
        this.customer = customer;
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        JTable table = new JTable(new DefaultTableModel(
                new Object[]{"Account Number", "Account Type", "Balance", "Activity Log"},
                0
        ));

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        List<BankAccount> bankAccounts = customer.getAvailableBankAccounts();

        for (BankAccount account : bankAccounts) {
            model.addRow(new Object[]{
                    account.getAccountNumber(),
                    account.getAccountType(),
                    account.getBalance(),
                    String.join("\n", account.getAccountActivities())
            });
        }

        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);
    }
}
