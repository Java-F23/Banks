import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class adminController {
    private final adminUI adminUI;
    private final Admin admin;

    public adminController(adminUI adminUI, Admin admin, ArrayList<customer> customers) {
        this.adminUI = adminUI;
        this.admin = admin;

        // Add action listeners for the buttons in the adminUI
        addActionListeners(customers);

        adminUI.setVisible(true);
    }

    private void addActionListeners(ArrayList<customer> customers) {
        JButton[] buttons = adminUI.getButtons();

        buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewCustomerDialog(customers);
            }
        });

        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAccountUI accountUI = new createAccountUI(admin, customers);
                accountUI.setVisible(true);
            }
        });

        buttons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAccountDetailsUI updateDetails = new updateAccountDetailsUI(admin.getBankAccounts(), admin.getBankAccountTypes());
                updateDetails.setVisible(true);
            }
        });

        buttons[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateReportsUI reportsUI = new generateReportsUI(admin.getBankAccounts());
                reportsUI.setVisible(true);
            }
        });

        buttons[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAccountTypeUI addAccTypeUI = new addAccountTypeUI(admin.getBankAccountTypes());
                addAccTypeUI.setVisible(true);
            }
        });

        buttons[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAccountTypeUI removeAccountTypeUI = new removeAccountTypeUI(admin.getBankAccountTypes());
                removeAccountTypeUI.setVisible(true);
            }
        });

        buttons[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getAccountsByCategoryUI getAcc = new getAccountsByCategoryUI(customers);
                getAcc.setVisible(true);
            }
        });
    }

    // Method to display a dialog for adding a new customer
    private void addNewCustomerDialog(ArrayList<customer> customers) {
        adminUI.addNewCustomerDialog(customers);
    }
}
