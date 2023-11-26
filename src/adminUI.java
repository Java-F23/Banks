import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class adminUI extends JFrame {
    private final Admin currAdmin;
    private final ArrayList<customer> allCusts;
    private final int height;
    private final int width;
    private final JPanel mainPanel;

    public adminUI(String frameName, int h, int w, Admin admin, ArrayList<customer> customers) {
        allCusts = customers;
        mainPanel = new JPanel();
        setTitle(frameName);
        width = w;
        height = h;
        this.setSize(width, height);
        setResizable(false);
        currAdmin = admin;
        JLabel welcomeMessage = new JLabel("Hello " + currAdmin.getName() + "!");
        welcomeMessage.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeMessage.setHorizontalAlignment(JLabel.CENTER);

        JButton addCustomerButton = createStyledButton("Add New Customer");
        JButton createAccountButton = createStyledButton("Create New Account");
        JButton updateAccountButton = createStyledButton("Update Account Details");
        JButton generateReportsButton = createStyledButton("Generate Reports");
        JButton addAccountTypeButton = createStyledButton("Add Account Type");
        JButton removeAccountTypeButton = createStyledButton("Remove Account Type");
        JButton browseAccountsButton = createStyledButton("Browse Accounts by Category");

        // Add components to the main panel
        mainPanel.setLayout(new GridLayout(8, 1, 0, 10)); // Increased the grid size and added vertical gap
        mainPanel.add(welcomeMessage);
        mainPanel.add(addCustomerButton); // Add the new customer button
        mainPanel.add(createAccountButton);
        mainPanel.add(updateAccountButton);
        mainPanel.add(generateReportsButton);
        mainPanel.add(addAccountTypeButton);
        mainPanel.add(removeAccountTypeButton);
        mainPanel.add(browseAccountsButton);

        // Add the main panel to the frame
        this.add(mainPanel);

        this.setLocationRelativeTo(null);
    }

    // Method to display a dialog for adding a new customer
    private void addNewCustomerDialog() {
        JTextField nameField = new JTextField(20);
        JTextField idField = new JTextField(10);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Customer ID:"));
        panel.add(idField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Add New Customer", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            // Get the values from the dialog
            try {
                int id = Integer.parseInt(idField.getText());

                // Check if the entered customer ID is already taken
                boolean isTaken = false;
                for (customer customer : allCusts) {
                    if (customer.getId() == id) {
                        isTaken = true;
                        break;
                    }
                }
                if (isTaken) {
                    // Display an error message if the customer ID is already taken
                    JOptionPane.showMessageDialog(this, "Customer ID is already taken. Please choose a different one.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Create a new customer and add them to the list
                    String name = nameField.getText();
                    customer newCustomer = new customer(id, name);
                    allCusts.add(newCustomer);
                    // You can display a success message or perform additional actions here.
                    JOptionPane.showMessageDialog(this, "Customer Created Successfully!");
                }
            } catch (NumberFormatException e) {
                // Display an error message if an invalid ID is entered
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
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
    public void addNewCustomerDialog(ArrayList<customer> customers) {
        JTextField nameField = new JTextField(20);
        JTextField idField = new JTextField(10);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Customer ID:"));
        panel.add(idField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Add New Customer", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            // Get the values from the dialog
            try {
                int id = Integer.parseInt(idField.getText());

                // Check if the entered customer ID is already taken
                boolean isTaken = false;
                for (customer customer : customers) {
                    if (customer.getId() == id) {
                        isTaken = true;
                        break;
                    }
                }
                if (isTaken) {
                    // Display an error message if the customer ID is already taken
                    JOptionPane.showMessageDialog(this, "Customer ID is already taken. Please choose a different one.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Create a new customer and add them to the list
                    String name = nameField.getText();
                    customer newCustomer = new customer(id, name);
                    customers.add(newCustomer);
                    // You can display a success message or perform additional actions here.
                    JOptionPane.showMessageDialog(this, "Customer Created Successfully!");
                }
            } catch (NumberFormatException e) {
                // Display an error message if an invalid ID is entered
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}