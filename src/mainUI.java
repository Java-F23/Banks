import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class mainUI extends JFrame {
    protected String title;
    protected int width;
    protected int height;
    protected JPanel mainPanel;
    private JButton adminUIButton;
    private JButton customerUIButton;
    private Admin admin;
    private ArrayList<Customer> allCustomers;

    public mainUI() {
        title = "";
        width = 800;
        height = 600;
        mainPanel = new JPanel();
        adminUIButton = new JButton();
        customerUIButton = new JButton();
        admin = new Admin();
        allCustomers = new ArrayList<Customer>();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public mainUI(String frameName, int h, int w, Admin a, ArrayList<Customer> custs) {
        adminUIButton = createStyledButton("Admin App");
        customerUIButton = createStyledButton("Customer App");
        mainPanel = new JPanel();
        title = frameName;
        height = h;
        width = w;
        admin = a;
        allCustomers = custs;
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
                adminPage.setVisible(true);
            }
        });

        customerUIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginCustomerUI loginUI = new loginCustomerUI(custs);
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
