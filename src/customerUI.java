import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class customerUI extends JFrame {
    //private buttons

    private final customer currCustomer;
    private final JPanel mainPanel;
    private final int height;
    private final int width;
    private final Bank bank;

    public customerUI(String frameName, int h, int w, customer cust, Bank b) {
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
    public JButton[] getButtons() {
        return Arrays.copyOfRange(mainPanel.getComponents(), 1, mainPanel.getComponentCount(), JButton[].class);
    }
}
