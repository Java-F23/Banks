import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class applyForLoanController {
    private final applyForLoanUI applyForLoanUI;
    private final customer customer;
    private final Bank bank;

    public applyForLoanController(applyForLoanUI applyForLoanUI, customer customer, Bank bank) {
        this.applyForLoanUI = applyForLoanUI;
        this.customer = customer;
        this.bank = bank;

        // Add action listener for the apply for loan button
        this.applyForLoanUI.getApplyLoanButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyForLoan();
            }
        });

        this.applyForLoanUI.setVisible(true);
    }

    private void applyForLoan() {
        try {
            double loanAmount = Double.parseDouble(applyForLoanUI.getLoanAmountField().getText());
            int loanTerm = Integer.parseInt(applyForLoanUI.getLoanTermField().getText());
            double interestRate = Double.parseDouble(applyForLoanUI.getInterestRateField().getText());

            if (loanAmount <= 0 || loanTerm <= 0 || interestRate <= 0) {
                applyForLoanUI.displayErrorMessage("Invalid input. Please enter valid loan details.");
            } else {
                // Convert interest rate to decimal
                interestRate = interestRate / 100;

                // Create a new loan
                Loan loan = new Loan(loanAmount, loanTerm, interestRate);

                // Add the loan to the bank
                bank.addLoan(loan);
                customer.addLoan(loan);

                // Inform the customer that the loan application was successful
                applyForLoanUI.displaySuccessMessage("Loan application submitted successfully.");
                // Close the apply for loan window
                applyForLoanUI.dispose();
            }
        } catch (NumberFormatException ex) {
            // Display an error message for invalid input
            applyForLoanUI.displayErrorMessage("Invalid input. Please enter valid loan details.");
        }
    }
}
