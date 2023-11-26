import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class mainUI extends JFrame {
    protected String title;
    protected JPanel mainPanel;
    private final JButton adminUIButton;
    private final JButton customerUIButton;
    private final admin admin;
    private final ArrayList<customer> allCustomers;
    private final Bank bank;

    public mainUI(String frameName, int h, int w, admin a, ArrayList<customer> custs, Bank b, ArrayList<BankAccount> accounts) {
        this.bank = b;
        adminUIButton = createStyledButton("Admin App");
        customerUIButton = createStyledButton("Customer App");
        mainPanel = new JPanel();
        title = frameName;
        admin = a;
        allCustomers = custs;
        admin.setAccounts(accounts);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(title);
        this.setSize(w, h);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        mainPanel.setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome to the Banking System App!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Larger font
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10)); // Added horizontal and vertical spacing

        adminUIButton.setFont(new Font("Arial", Font.BOLD, 18)); // Larger font
        customerUIButton.setFont(new Font("Arial", Font.BOLD, 18)); // Larger font

        buttonsPanel.add(adminUIButton);
        buttonsPanel.add(customerUIButton);

        mainPanel.add(welcomeLabel, BorderLayout.NORTH);
        mainPanel.add(buttonsPanel, BorderLayout.CENTER);
        mainPanel.setBackground(new Color(240, 240, 240)); // Background color

        this.add(mainPanel);

        adminUIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminUI adminPage = new adminUI("Admin Panel", 400, 400, admin, allCustomers);
                adminController controller = new adminController(adminPage, admin, allCustomers);
            }
        });

        customerUIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginCustomerUI loginUI = new loginCustomerUI(custs, bank);
                loginUI.setVisible(true);
            }
        });
    }

    // Method to create styled buttons
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(66, 134, 244)); // Background color
        button.setForeground(Color.WHITE); // Text color
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setFocusPainted(false); // Remove focus border
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Change cursor to hand on hover
        button.setPreferredSize(new Dimension(180, 50)); // Set button size
        return button;
    }
}
