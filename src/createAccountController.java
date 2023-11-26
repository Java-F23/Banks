import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class createAccountController {
    private final createAccountUI createAccountUI;

    public createAccountController(createAccountUI createUI, admin admin, ArrayList<customer> customers) {
        this.createAccountUI = createUI;

        // Add action listener for the create account button directly
        this.createAccountUI.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the selected account type, initial balance, and customer ID
                    int selectedAccountType = createAccountUI.getAccountTypeComboBox().getSelectedIndex();

                    // Check if input fields are empty
                    String initialBalanceText = createAccountUI.getInitialBalanceField().getText();
                    String customerIdText = createAccountUI.getCustomerIdField().getText();

                    if (initialBalanceText.isEmpty() || customerIdText.isEmpty()) {
                        throw new IllegalArgumentException("Input fields cannot be empty.");
                    }

                    int initialBalance = Integer.parseInt(initialBalanceText);
                    int customerId = Integer.parseInt(customerIdText);

                    customer customer = Main.findCustomerByID(customers, customerId);
                    if (customer == null) {
                        // Display an error message if the customer is not found
                        createAccountUI.displayErrorMessage("Customer not found. Please enter a valid customer ID.");
                    } else {
                        // Create the bank account using admin and the provided data
                        BankAccount newAcc = admin.createNewAccount(selectedAccountType + 1, initialBalance, customerId);
                        customer.addBankAccount(newAcc);
                        // Display a success message using JOptionPane
                        createAccountUI.displaySuccessMessage("Account created successfully!\nAccount Number: " + newAcc.getAccountNumber());

                        // Close the create account window
                        createAccountUI.dispose();
                    }
                } catch (NumberFormatException ex) {
                    // Display an error message if there's an issue with parsing numbers
                    createAccountUI.displayErrorMessage("Invalid input. Please enter valid numbers.");
                } catch (IllegalArgumentException ex) {
                    // Display an error message for empty input fields
                    createAccountUI.displayErrorMessage(ex.getMessage());
                }
            }
        });

        this.createAccountUI.setVisible(true);
    }
}