import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class applyForLoanUI extends JFrame {

    private final JTextField loanAmountField;
    private final JTextField loanTermField;
    private final JTextField interestRateField;
    private final JButton applyLoanButton;

    public applyForLoanUI(Customer cust, Bank bank) {
        super("Apply for Loan");
        this.setSize(400, 200);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        inputPanel.add(new JLabel("Loan Amount:"));
        loanAmountField = new JTextField(10);
        inputPanel.add(loanAmountField);

        inputPanel.add(new JLabel("Loan Term (in months):"));
        loanTermField = new JTextField(10);
        inputPanel.add(loanTermField);

        inputPanel.add(new JLabel("Interest Rate (%):"));
        interestRateField = new JTextField(10);
        inputPanel.add(interestRateField);

        applyLoanButton = new JButton("Apply for Loan");
        inputPanel.add(new JPanel()); // Empty panel for spacing
        inputPanel.add(applyLoanButton);

        this.add(inputPanel, BorderLayout.CENTER);

        applyLoanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyForLoan(cust, bank);
            }
        });
    }

    private void applyForLoan(Customer cust, Bank bank) {
        try {
            double loanAmount = Double.parseDouble(loanAmountField.getText());
            int loanTerm = Integer.parseInt(loanTermField.getText());
            double interestRate = Double.parseDouble(interestRateField.getText());

            if (loanAmount <= 0 || loanTerm <= 0 || interestRate <= 0) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid loan details.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Convert interest rate to decimal
                interestRate = interestRate / 100;

                // Create a new loan
                Loan loan = new Loan(loanAmount, loanTerm, interestRate);

                // Add the loan to the bank
                bank.addLoan(loan);
                cust.addLoan(loan);

                // Inform the customer that the loan application was successful
                JOptionPane.showMessageDialog(this, "Loan application submitted successfully.", "Loan Application", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            // Display an error message for invalid input
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid loan details.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
