import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class loginCustomerUI extends JFrame {
    private final JLabel nameLabel;
    private final JTextField custIDField;
    private final JButton loginButton;
    private final ArrayList<customer> allCustomers;
    private final Bank bank;

    public loginCustomerUI(ArrayList<customer> customers, Bank b) {
        super("Customer Login");
        this.bank = b;
        this.setSize(400, 150);
        this.setLayout(new GridLayout(3, 1));
        this.setLocationRelativeTo(null);

        // Create a greeting message using HTML tags and center it
        nameLabel = new JLabel("Welcome, please enter your ID:");
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        custIDField = new JTextField(20);
        custIDField.setFont(new Font("Arial", Font.PLAIN, 16));

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setBackground(new Color(66, 134, 244));
        loginButton.setForeground(Color.WHITE);
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.add(nameLabel);
        this.add(custIDField);
        this.add(loginButton);

        allCustomers = customers;

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int customerID = Integer.parseInt(custIDField.getText());
                boolean customerFound = false;

                for (customer customer : allCustomers) {
                    if (customer.getId() == customerID) {
                        customerFound = true;
                        openCustomerUI(customer);
                        break;
                    }
                }

                if (!customerFound) {
                    // Display a dialog prompt if the customer is not available
                    JOptionPane.showMessageDialog(null, "Customer not found. Please check your ID or register as a new customer.", "Customer Not Found", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void openCustomerUI(customer customer) {
        // Create and display the CustomerUI for the authenticated customer
        customerUI ui = new customerUI("Customer App", 600, 400, customer, bank);
        customerController controller = new customerController(ui, customer, bank);
    }
}
