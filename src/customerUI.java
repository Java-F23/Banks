import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class customerUI extends JFrame{
    //private buttons

    private Customer currCustomer;
    private JPanel mainPanel;
    private int height;
    private int width;

    public customerUI()
    {
        setTitle("");
        width = 400;
        height = 400;
        mainPanel = new JPanel();
        currCustomer = new Customer();
        setResizable(false);

    }

    public customerUI(String frameName, int h, int w, Customer cust)
    {
        currCustomer = cust;
        mainPanel = new JPanel();
        setTitle(frameName);
        width = w;
        height = h;
        this.setSize(width, height);
        setResizable(false);
        mainPanel.setLayout(new GridLayout(12, 1, 0, 10));
        mainPanel.setBackground(new Color(240, 240, 240));
        // Create a label to display customer information
        JLabel customerInfoLabel = new JLabel("Welcome, " + cust.getName() + " (ID: " + cust.getId() + ")");
        customerInfoLabel.setFont(new Font("Arial", Font.BOLD, 18));
        customerInfoLabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(customerInfoLabel);

        // Create buttons with a consistent style
        JButton[] buttons = {
                createStyledButton("View Available Accounts"),
                createStyledButton("Search Accounts"),
                createStyledButton("View Account Details"),
                createStyledButton("Mark Account as Favorite"),
                createStyledButton("Deposit Money"),
                createStyledButton("Withdraw Money"),
                createStyledButton("View Favorite Accounts"),
                createStyledButton("Transfer Between Accounts"),
                createStyledButton("View All Activities"),
                createStyledButton("View Activity of An Account"),
                createStyledButton("Apply For A Loan")
        };

        for (JButton button : buttons) {
            mainPanel.add(button);
        }

        this.add(mainPanel);
        this.setLocationRelativeTo(null);
// Add action listeners for the buttons
        buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allAccountsUI viewAccs = new allAccountsUI(currCustomer);
                viewAccs.setVisible(true);
            }
        });

        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchAccountsUI searchUI = new searchAccountsUI(currCustomer);
                searchUI.setVisible(true);
            }
        });

        buttons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the action for viewing account details
            }
        });

        buttons[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markFavoriteAccountUI markAcc = new markFavoriteAccountUI(currCustomer);
                markAcc.setVisible(true);
            }
        });

        buttons[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depositUI deposit = new depositUI(currCustomer);
                deposit.setVisible(true);
            }
        });

        buttons[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdrawUI withdraw = new withdrawUI(currCustomer);
                withdraw.setVisible(true);
            }
        });

        buttons[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                favoriteAccsUI favAccs = new favoriteAccsUI(currCustomer);
                favAccs.setVisible(true);
            }
        });

        buttons[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the action for transferring between accounts
            }
        });

        buttons[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the action for viewing all activities
            }
        });

        buttons[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the action for viewing activity of an account
            }
        });

        buttons[10].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the action for applying for a loan
            }
        });
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(66, 134, 244)); // Background color
        button.setForeground(Color.WHITE); // Text color
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setFocusPainted(false); // Remove focus border
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Change cursor to hand on hover
        return button;
    }
}
