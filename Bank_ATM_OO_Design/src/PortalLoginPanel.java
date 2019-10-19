import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PortalLoginPanel {
    private JFrame frame;

    private boolean loginAuth(String userID, String password, String identity) {
        String response = Bank.getInstance().authenticateUser(userID, password, identity);
        JOptionPane.showMessageDialog(frame, "Response:" + response);
        switch(response) {
            case "NotExist":
                JOptionPane.showMessageDialog(frame, "User does not exist!");
                return false;
            case "WrongPass":
                JOptionPane.showMessageDialog(frame, "Wrong password!");
                return false;
            case "Error":
                JOptionPane.showMessageDialog(frame, "Unexpected Error!");
            default:
                return true;
        }
    }

    public PortalLoginPanel() {
        this.frame = new JFrame();
        frame.setTitle("Bank Login Panel");
        frame.setBounds(100, 500, 600, 100);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(null);
        frame.setLayout(new FlowLayout(FlowLayout.RIGHT));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JRadioButton radioButton_1 = new JRadioButton("Manager");
        JRadioButton radioButton_2 = new JRadioButton("Customer");
        radioButton_1.setBounds(100, 100, 100, 30);
        radioButton_2.setBounds(300, 100, 100, 30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton_1);
        bg.add(radioButton_2);
        frame.add(radioButton_1);
        frame.add(radioButton_2);

        JTextField userIDField = new JTextField(8);
        JLabel userIDLabel = new JLabel("ID:");
//        userIDLabel.setBounds(50, 90, 100, 20);
        JPasswordField userPassField = new JPasswordField(12);
//        JTextField userPassField = new JTextField(12);
//        userIDLabel.setBounds(50, 500, 110, 20);

        JLabel userPassLabel = new JLabel("Password:");

        userIDField.setHorizontalAlignment(JTextField.LEFT);
        userPassField.setHorizontalAlignment(JPasswordField.LEFT);

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Signup");


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userID = userIDField.getText();
                String password = new String(userPassField.getPassword());
                if (userID.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in your ID.");
                } else if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in your password.");
                } else if (radioButton_1.isSelected()) {
                    if (loginAuth(userID, password, radioButton_1.getText())) {
                        JOptionPane.showMessageDialog(frame, "Welcome " + radioButton_1.getText() + " " + userID + "!");
                    }
                } else if (radioButton_2.isSelected()) {
                    if (loginAuth(userID, password, radioButton_2.getText())) {
                        JOptionPane.showMessageDialog(frame, "Welcome " + radioButton_2.getText() + " " + userID + "!");
                    }
                } else if (!radioButton_1.isSelected() && !radioButton_2.isSelected()) {
                    JOptionPane.showMessageDialog(frame, "Please select your identity. Manager/Customer?");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userID = userIDField.getText();
                String password = new String(userPassField.getPassword());
                if (userID.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in your ID.");
                } else if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in your password.");
                } else if (radioButton_1.isSelected()) {
                    JOptionPane.showMessageDialog(frame, "Manager " + userID + ", you have successfully signed up!");
                    Bank.getInstance().addUser(userID, password, null, radioButton_1.getText());
                } else if (radioButton_2.isSelected()) {
                    JOptionPane.showMessageDialog(frame, "Customer " + userID + ", you have successfully signed up!");
                    Bank.getInstance().addUser(userID, password, null, radioButton_2.getText());
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select your identity. Manager/Customer?");
                }
            }
        });

        contentPane.add(userIDLabel);
        contentPane.add(userIDField);
        contentPane.add(userPassLabel);
        contentPane.add(userPassField);
        contentPane.add(loginButton);
        contentPane.add(registerButton);
        frame.setVisible(true);
    }

}
