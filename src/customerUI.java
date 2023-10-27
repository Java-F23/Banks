import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class customerUI extends mainUI{
    //private buttons

    private Customer currCustomer;

    public customerUI()
    {
        title = "";
        width = 400;
        height = 400;
        mainPanel = new JPanel();
        currCustomer = new Customer();
    }

    public customerUI(String frameName, int h, int w, Customer cust)
    {
        mainPanel = new JPanel();
        title = frameName;
        setTitle(title);
        width = w;
        height = h;
        this.setSize(w,h);
        currCustomer = cust;
        // Create buttons for each option
        JButton viewAccountsButton = new JButton("View Available Accounts");
        JButton searchAccountsButton = new JButton("Search Accounts");
        JButton viewAccountDetailsButton = new JButton("View Account Details");
        JButton markFavoriteButton = new JButton("Mark Account as Favorite");
        JButton depositMoneyButton = new JButton("Deposit Money");
        JButton withdrawMoneyButton = new JButton("Withdraw Money");
        JButton viewFavoriteAccountsButton = new JButton("View Favorite Accounts");
        JButton transferBetweenAccountsButton = new JButton("Transfer Between Accounts");
        JButton viewAllActivitiesButton = new JButton("View All Activities");
        JButton viewActivityButton = new JButton("View Activity of An Account");
        JButton applyForLoanButton = new JButton("Apply For A Loan");
        JButton backToMainMenuButton = new JButton("Back to Main Menu");

        mainPanel.setLayout(new GridLayout(12, 1));
        mainPanel.add(viewAccountsButton);
        mainPanel.add(searchAccountsButton);
        mainPanel.add(viewAccountDetailsButton);
        mainPanel.add(markFavoriteButton);
        mainPanel.add(depositMoneyButton);
        mainPanel.add(withdrawMoneyButton);
        mainPanel.add(viewFavoriteAccountsButton);
        mainPanel.add(transferBetweenAccountsButton);
        mainPanel.add(viewAllActivitiesButton);
        mainPanel.add(viewActivityButton);
        mainPanel.add(applyForLoanButton);
        mainPanel.add(backToMainMenuButton);

        // Add the main panel to the frame
        this.add(mainPanel);

        this.setLocationRelativeTo(null);

// Add action listeners for the buttons
        viewAccountsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the action for viewing available accounts
            }
        });

        searchAccountsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the action for searching accounts
            }
        });

        viewAccountDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the action for viewing account details
            }
        });

        markFavoriteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the action for marking an account as a favorite
            }
        });

        depositMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the action for depositing money
            }
        });

        withdrawMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the action for withdrawing money
            }
        });

        viewFavoriteAccountsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the action for viewing favorite accounts
            }
        });

        transferBetweenAccountsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the action for transferring between accounts
            }
        });

        viewAllActivitiesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the action for viewing all activities
            }
        });

        viewActivityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the action for viewing activity of an account
            }
        });

        applyForLoanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the action for applying for a loan
            }
        });

        backToMainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the action for going back to the main menu
            }
        });

    }
}
