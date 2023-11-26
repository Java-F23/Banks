import javax.swing.*;
import java.awt.*;
import java.util.List;

public class favoriteAccsUI extends JFrame {

    public favoriteAccsUI(Customer customer) {
        super("Favorite Accounts");
        this.setSize(600, 400);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        // Get the favorite accounts for the customer
        List<BankAccount> favoriteAccounts = customer.getFavoriteAccounts();

        // Create a panel to display the favorite account information
        JPanel accountPanel = new JPanel();
        accountPanel.setLayout(new GridLayout(favoriteAccounts.size(), 1, 0, 10));

        for (BankAccount account : favoriteAccounts) {
            JLabel accountLabel = new JLabel("Account ID: " + account.getAccountNumber() + ", Balance: $" + account.getBalance());
            accountLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            accountPanel.add(accountLabel);
        }

        // Add the favorite account panel to the frame
        JScrollPane scrollPane = new JScrollPane(accountPanel);
        this.add(scrollPane, BorderLayout.CENTER);
    }
}
