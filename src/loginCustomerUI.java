import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class loginCustomerUI extends JFrame {
    private JLabel nameLabel;
    private JTextField custIDField;
    private JButton loginButton;

    private ArrayList<Customer> allCustomers;

    public loginCustomerUI(ArrayList<Customer> customers) {
        super("Customer Login");
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

                for (Customer customer : allCustomers) {
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

    private void openCustomerUI(Customer customer) {
        // Create and display the CustomerUI for the authenticated customer
        customerUI customerUI = new customerUI("Customer Panel", 400, 400, customer);
        customerUI.setVisible(true);
    }
}
