import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class customer {
    private final int id;
    private final String name;
    private final ArrayList<BankAccount> bankAccounts;
    private final ArrayList<BankAccount> favoriteAccounts;

    private final List<Loan> loanApplications;

    public customer(int id, String name) {
        this.id = id;
        this.name = name;
        this.bankAccounts = new ArrayList<>();
        this.favoriteAccounts = new ArrayList<>();
        loanApplications = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addBankAccount(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
    }

    public ArrayList<BankAccount> getAvailableBankAccounts() {
        return bankAccounts;
    }

    public List<BankAccount> searchBankAccountsByFilter(int accountType, double minBalance, double maxBalance) {
        List<BankAccount> matchingAccounts = new ArrayList<>();
        for (BankAccount account : bankAccounts) {
            if (account.getCustomerID() == this.id && (accountType == -1 || account.getAccountType() == accountType) &&
                    (minBalance <= account.getBalance() && account.getBalance() <= maxBalance)) {
                matchingAccounts.add(account);
            }
        }
        return matchingAccounts;
    }

    public void markAccountAsFavorite(BankAccount account) {
        if (account != null) {
            favoriteAccounts.add(account);
            JOptionPane.showMessageDialog(null, "Account marked as favorite.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Account not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<BankAccount> getFavoriteAccounts() {
        return favoriteAccounts;
    }

    public void addLoan(Loan currLoan) {
        this.loanApplications.add(currLoan);
    }

}

