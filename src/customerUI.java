import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class customerUI extends JFrame{
    //private buttons

    private final Customer currCustomer;
    private final JPanel mainPanel;
    private final int height;
    private final int width;
    private Bank bank;

    public customerUI()
    {
        setTitle("");
        width = 400;
        height = 400;
        mainPanel = new JPanel();
        currCustomer = new Customer();
        setResizable(false);
    }

    public customerUI(String frameName, int h, int w, Customer cust, Bank b)
    {
        this.bank = b;
        currCustomer = cust;
        mainPanel = new JPanel();
        setTitle(frameName);
        width = w;
        height = h;
        this.setSize(width, height);
        setResizable(false);
        mainPanel.setLayout(new GridLayout(11, 1, 0, 10));
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
                markFavoriteAccountUI markAcc = new markFavoriteAccountUI(currCustomer);
                markAcc.setVisible(true);
            }
        });

        buttons[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depositUI deposit = new depositUI(currCustomer);
                deposit.setVisible(true);
            }
        });

        buttons[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdrawUI withdraw = new withdrawUI(currCustomer);
                withdraw.setVisible(true);
            }
        });

        buttons[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                favoriteAccsUI favAccs = new favoriteAccsUI(currCustomer);
                favAccs.setVisible(true);
            }
        });

        buttons[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transferBetweenAccsUI transferUI = new transferBetweenAccsUI(currCustomer);
                transferUI.setVisible(true);
            }
        });

        buttons[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allRecordsUI viewRecsUI = new allRecordsUI(currCustomer);
                viewRecsUI.setVisible(true);
            }
        });

        buttons[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAccountRecordsUI viewAccRecs = new viewAccountRecordsUI(currCustomer);
                viewAccRecs.setVisible(true);
            }
        });

        buttons[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyForLoanUI applyLoanUI = new applyForLoanUI(currCustomer, bank);
                applyLoanUI.setVisible(true);
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
