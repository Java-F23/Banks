import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final List<Admin> admins;
    private final List<customer> customers;
    private final List<Loan> loans;

    public Bank() {
        this.customers = new ArrayList<>();
        this.loans = new ArrayList<>();
        this.admins = new ArrayList<>();
    }

    // Methods for managing customers
    public void addCustomer(customer customer) {
        customers.add(customer);
    }

    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    // Methods for managing loans
    public void addLoan(Loan loan) {
        loans.add(loan);
    }
}
