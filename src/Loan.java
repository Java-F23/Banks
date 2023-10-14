public class Loan {
    private static int nextLoanID = 1;

    private int loanID;
    private double loanAmount;
    private int loanTerm; // Term in months
    private double interestRate;
    private String status;

    private int customerID;

    public Loan(double loanAmount, int loanTerm, double interestRate, int custID) {
        this.loanID = nextLoanID++;
        this.loanAmount = loanAmount;
        this.loanTerm = loanTerm;
        this.interestRate = interestRate;
        this.status = "Pending"; // Initial status is pending
        this.customerID = custID;
    }

    public int getLoanID() {
        return loanID;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String newStatus) {
        status = newStatus;
    }

    public double calculateTotalAmountPayable() {
        // Calculate the total amount payable, including interest
        double totalAmount = loanAmount + (loanAmount * interestRate * loanTerm / 100.0);
        return totalAmount;
    }
}