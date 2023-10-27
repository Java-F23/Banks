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
        width = 400;
        height = 400;
        mainPanel = new JPanel();
        adminUIButton = new JButton();
        customerUIButton = new JButton();
        admin = new Admin();
        allCustomers = new ArrayList<Customer>();
    }

    public mainUI(String frameName, int h, int w, Admin a, ArrayList<Customer> custs) {
        adminUIButton = new JButton("Admin App");
        customerUIButton = new JButton("Customer App");
        mainPanel = new JPanel();
        title = frameName;
        height = h;
        width = w;
        admin = a;
        allCustomers = custs;
        this.setTitle(title);
        this.setSize(w, h);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        mainPanel.setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome to the Banking Java App!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());

        adminUIButton.setFont(new Font("Arial", Font.BOLD, 16));
        customerUIButton.setFont(new Font("Arial", Font.BOLD, 16));

        buttonsPanel.add(adminUIButton);
        buttonsPanel.add(customerUIButton);

        mainPanel.add(welcomeLabel, BorderLayout.NORTH);
        mainPanel.add(buttonsPanel, BorderLayout.CENTER);

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
                customerUI custPage = new customerUI("Customer Panel", 400, 400, new Customer());
                custPage.setVisible(true);
            }
        });
    }
}
