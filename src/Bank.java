import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final String bankName;
    private final String address;
    private final List<Admin> admins;
    private final List<Customer> customers;
    private final List<BankAccount> accounts;
    private final List<Loan> loans;

    public Bank(String name, String location) {
        this.customers = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.loans = new ArrayList<>();
        this.admins = new ArrayList<>();
        this.bankName = name;
        this.address = location;
    }

    // Methods for managing customers
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    public Customer findCustomerById(int customerId) {
        for (Customer customer : customers) {
            if (customer.getId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    // Methods for managing accounts
    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    // Methods for managing loans
    public void addLoan(Loan loan) {
        loans.add(loan);
    }
}
