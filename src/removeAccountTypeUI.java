import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class removeAccountTypeUI extends JFrame {
    private final JTextField accountTypeField;
    private final JButton removeButton;

    public removeAccountTypeUI(ArrayList<BankAccountType> accountTypes) {
        setTitle("Remove Account Type");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JLabel accountTypeLabel = new JLabel("Enter Account Type:");
        accountTypeField = new JTextField();

        removeButton = new JButton("Remove Account Type");

        panel.add(accountTypeLabel);
        panel.add(accountTypeField);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(removeButton);

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAccountType(accountTypes);
            }
        });

        add(panel);
    }

    private void removeAccountType(ArrayList<BankAccountType> accountTypes) {
        try {
            String typeName = "";
            int typeToRemove = Integer.parseInt(accountTypeField.getText());

            BankAccountType typeToRemoveObject = null;
            for (BankAccountType accountType : accountTypes) {
                if (accountType.getType() == typeToRemove) {
                    typeToRemoveObject = accountType;
                    typeName = accountType.getName();
                    break;
                }
            }

            if (typeToRemoveObject != null) {
                accountTypes.remove(typeToRemoveObject);
                JOptionPane.showMessageDialog(this, "Account type: "+typeName+" is removed successfully!");
                dispose(); // Close the frame
            } else {
                JOptionPane.showMessageDialog(this, "Account type not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
