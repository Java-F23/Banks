import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class customerController {
    private final customerUI customerUI;
    private final customer customer;
    private final Bank bank;

    public customerController(customerUI customerUI, customer customer, Bank bank) {
        this.customerUI = customerUI;
        this.customer = customer;
        this.bank = bank;
        customerUI.setVisible(true);

        // Add action listeners for the buttons in the customerUI
        addActionListeners();
    }

    private void addActionListeners() {
        JButton[] buttons = customerUI.getButtons();

        buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAvailableAccounts();
            }
        });

        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchAccounts();
            }
        });

        buttons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markAccountAsFavorite();
            }
        });

        buttons[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depositMoney();
            }
        });

        buttons[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdrawMoney();
            }
        });

        buttons[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewFavoriteAccounts();
            }
        });

        buttons[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transferBetweenAccounts();
            }
        });

        buttons[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAllActivities();
            }
        });

        buttons[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewActivityOfAnAccount();
            }
        });

        buttons[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyForLoan();
            }
        });
    }

    private void viewAvailableAccounts() {
        allAccountsUI viewAccs = new allAccountsUI(customer);
        viewAccs.setVisible(true);
    }

    private void searchAccounts() {
        searchAccountsUI searchUI = new searchAccountsUI(customer);
        searchUI.setVisible(true);
    }

    private void markAccountAsFavorite() {
        markFavoriteAccountUI markAcc = new markFavoriteAccountUI(customer);
        markAcc.setVisible(true);
    }

    private void depositMoney() {
        depositUI deposit = new depositUI(customer);
        deposit.setVisible(true);
    }

    private void withdrawMoney() {
        withdrawUI withdraw = new withdrawUI(customer);
        withdraw.setVisible(true);
    }

    private void viewFavoriteAccounts() {
        favoriteAccsUI favAccs = new favoriteAccsUI(customer);
        favAccs.setVisible(true);
    }

    private void transferBetweenAccounts() {
        transferBetweenAccsUI transferUI = new transferBetweenAccsUI(customer);
        transferUI.setVisible(true);
    }

    private void viewAllActivities() {
        allRecordsUI viewRecsUI = new allRecordsUI(customer);
        viewRecsUI.setVisible(true);
    }

    private void viewActivityOfAnAccount() {
        viewAccountRecordsUI viewAccRecs = new viewAccountRecordsUI(customer);
        viewAccRecs.setVisible(true);
    }

    private void applyForLoan() {
        applyForLoanUI applyLoanUI = new applyForLoanUI(customer, bank);
        applyForLoanController controller = new applyForLoanController(applyLoanUI, customer, bank);
    }
}
