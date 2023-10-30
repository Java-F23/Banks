import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class viewAccountRecordsUI extends JFrame {
    private Customer customer;
    private JComboBox<BankAccount> accountComboBox;

    public viewAccountRecordsUI(Customer customer) {
        super("View Account Records");
        this.customer = customer;
        this.setSize(700, 150);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        // Create a combo box to list available accounts
        List<BankAccount> bankAccounts = customer.getAvailableBankAccounts();
        accountComboBox = new JComboBox<>(bankAccounts.toArray(new BankAccount[0]));

        // Create a button to view account records
        JButton viewRecordsButton = new JButton("View Account Records");

        // Create a text area to display the records
        JTextArea recordsTextArea = new JTextArea();
        recordsTextArea.setEditable(false);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(new JLabel("Select an account:"));
        topPanel.add(accountComboBox);
        topPanel.add(viewRecordsButton);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(new JScrollPane(recordsTextArea), BorderLayout.CENTER);

        viewRecordsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BankAccount selectedAccount = (BankAccount) accountComboBox.getSelectedItem();
                if (selectedAccount != null) {
                    recordsTextArea.setText(""); // Clear the text area
                    recordsTextArea.setText(selectedAccount.getAccountActivities().toString());
                } else {
                    recordsTextArea.setText("No account selected.");
                }
            }
        });
    }
}
