import java.util.List;

public class updateAccountDetailsController {
    private final updateAccountDetailsUI updateAccountDetailsUI;
    private final List<BankAccount> accounts;
    private final List<BankAccountType> accountTypes;

    public updateAccountDetailsController(updateAccountDetailsUI updateUI, List<BankAccount> accounts, List<BankAccountType> accountTypes) {
        this.updateAccountDetailsUI = updateUI;
        this.accounts = accounts;
        this.accountTypes = accountTypes;

        this.updateAccountDetailsUI.getUpdateButton().addActionListener(e -> updateAccountDetails());
        this.updateAccountDetailsUI.setVisible(true);
    }

    private void updateAccountDetails() {
        try {
            int accountNumber = Integer.parseInt(updateAccountDetailsUI.getAccountNumberField().getText());
            int selectedAccountTypeIndex = updateAccountDetailsUI.getAccountTypeComboBox().getSelectedIndex();
            int newAccountType = accountTypes.get(selectedAccountTypeIndex).getType();
            double newBalance = Double.parseDouble(updateAccountDetailsUI.getBalanceField().getText());

            BankAccount accountToUpdate = null;
            for (BankAccount account : accounts) {
                if (account.getAccountNumber() == accountNumber) {
                    accountToUpdate = account;
                    break;
                }
            }

            if (accountToUpdate == null) {
                updateAccountDetailsUI.displayErrorMessage("Account not found.");
                return;
            }

            // Now update the account details.
            accountToUpdate.updateAccount(newAccountType, newBalance);
            updateAccountDetailsUI.displaySuccessMessage("Account details updated.");
        } catch (NumberFormatException ex) {
            updateAccountDetailsUI.displayErrorMessage("Invalid input. Please check the data entered.");
        }
    }
}
