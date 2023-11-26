import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class applyForLoanUI extends JFrame {

    private final JTextField loanAmountField;
    private final JTextField loanTermField;
    private final JTextField interestRateField;
    private final JButton applyLoanButton;

    public applyForLoanUI(customer cust, Bank bank) {
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
    }

    public JButton getApplyLoanButton()
    {
        return applyLoanButton;
    }

    public JTextField getLoanAmountField() {
        return loanAmountField;
    }

    public JTextField getLoanTermField() {
        return loanTermField;
    }

    public JTextField getInterestRateField() {
        return interestRateField;
    }

    public void displayErrorMessage(String errorMessage) {
        displayMessage(errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void displaySuccessMessage(String successMessage) {
        displayMessage(successMessage, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void displayMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }
}
