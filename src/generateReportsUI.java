import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class generateReportsUI extends JFrame {
    private JTable reportsTable;
    private JScrollPane scrollPane;
    private JButton generateButton;

    public generateReportsUI(List<BankAccount> accounts) {
        setTitle("Generate Reports");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Account Number", "Balance"}, 0);
        reportsTable = new JTable(tableModel);
        reportsTable.setFont(new Font("Arial", Font.PLAIN, 16));

        scrollPane = new JScrollPane(reportsTable);

        generateButton = new JButton("Generate Reports");
        generateButton.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(generateButton, BorderLayout.SOUTH);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateReports(tableModel, accounts);
            }
        });

        add(panel);
    }

    private void generateReports(DefaultTableModel tableModel, List<BankAccount> accounts) {
        tableModel.setRowCount(0);

        for (BankAccount account : accounts) {
            Object[] rowData = {account.getAccountNumber(), "$" + account.getBalance()};
            tableModel.addRow(rowData);
        }
    }
}
