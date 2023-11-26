public class Loan {
    private static int nextLoanID = 1;

    private final int loanID;
    private final double loanAmount;
    private final int loanTerm; // Term in months
    private final double interestRate;
    private final String status;

    public Loan(double loanAmount, int loanTerm, double interestRate) {
        this.loanID = nextLoanID++;
        this.loanAmount = loanAmount;
        this.loanTerm = loanTerm;
        this.interestRate = interestRate;
        this.status = "Pending"; // Initial status is pending
    }
}